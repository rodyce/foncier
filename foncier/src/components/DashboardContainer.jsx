import React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import {
  AccountCircle, Dashboard, QrCode, QrCodeScanner,
} from '@mui/icons-material';
import { useTheme } from '@mui/material/styles';
import useMediaQuery from '@mui/material/useMediaQuery';
import Feed from './Feed';
import Leftbar from './Leftbar';
import Navbar from './Navbar';

const leftMenu = {
  sections: [
    {
      sectionName: 'Section 1',
      buttons: [
        {
          text: 'Home',
          icon: <AccountCircle />,
          path: '/',
        },
      ],
    },
    {
      sectionName: 'Section 2',
      buttons: [
        {
          text: 'Opt 1',
          icon: <Dashboard />,
          path: '/',
        },
        {
          text: 'Opt 2',
          icon: <QrCode />,
          path: '/',
        },
      ],
    },
    {
      sectionName: 'Section 3',
      buttons: [
        {
          text: 'Opt 1',
          icon: <QrCodeScanner />,
          path: '/',
        },
      ],
    },
  ],
};

function DashboardContainer({ title }) {
  const theme = useTheme();
  const isBigScreen = useMediaQuery(theme.breakpoints.up('sm'), { noSsr: true });
  const [open, setOpen] = React.useState(isBigScreen);

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <Navbar
        handleDrawerOpen={handleDrawerOpen}
        open={open}
        isBigScreen={isBigScreen}
        title={title}
      />
      <Leftbar
        handleDrawerClose={handleDrawerClose}
        open={open}
        isBigScreen={isBigScreen}
        leftMenu={leftMenu}
      />
      <Feed />
    </Box>
  );
}

export default DashboardContainer;
