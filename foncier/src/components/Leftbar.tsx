import * as React from "react";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import ListItem from "@mui/material/ListItem";
import MuiDrawer from "@mui/material/Drawer";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import IconButton from "@mui/material/IconButton";
import Divider from "@mui/material/Divider";
import List from "@mui/material/List";
import { styled, useTheme } from "@mui/material/styles";
import Box from "@mui/material/Box";
import { Link } from "react-router-dom";

const drawerWidth = 240;

const DrawerHeader = styled("div")(({ theme }) => ({
  display: "flex",
  alignItems: "center",
  justifyContent: "flex-end",
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
}));

const StyledDrawer = styled(MuiDrawer, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  flexShrink: 0,
  whiteSpace: "nowrap",
  boxSizing: "border-box",
  overflowX: "hidden",
  ...(open && {
    width: drawerWidth,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
    "& .MuiDrawer-paper": {
      width: drawerWidth,
      transition: theme.transitions.create("width", {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.enteringScreen,
      }),
      overflowX: "hidden",
    },
  }),
  ...(!open && {
    width: `calc(${theme.spacing(7)} + 1px)`,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    "& .MuiDrawer-paper": {
      width: `calc(${theme.spacing(7)} + 1px)`,
      transition: theme.transitions.create("width", {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.leavingScreen,
      }),
      overflowX: "hidden",
    },
  }),
}));

type LeftbarProps = {
  handleDrawerClose: () => void;
  open: boolean;
  isBigScreen: boolean;
  leftMenu: SideMenuOptions;
};

function Leftbar({
  handleDrawerClose,
  open,
  isBigScreen,
  leftMenu,
}: LeftbarProps) {
  const theme = useTheme();

  const Drawer = isBigScreen ? StyledDrawer : MuiDrawer;

  return (
    <Drawer
      variant={isBigScreen ? "permanent" : "temporary"}
      open={open}
      role="presentation"
      ModalProps={{ onBackdropClick: handleDrawerClose }}
    >
      <DrawerHeader onClick={handleDrawerClose}>
        <IconButton>
          {theme.direction === "rtl" ? (
            <ChevronRightIcon />
          ) : (
            <ChevronLeftIcon />
          )}
        </IconButton>
      </DrawerHeader>
      {leftMenu.sections.map((section) => (
        <Box key={section.sectionName}>
          {open ? (
            <Divider sx={{ color: "#96948d" }}>{section.sectionName}</Divider>
          ) : null}
          <List sx={{ padding: open ? "8px 0 8px 0" : 0 }}>
            {section.buttons.map((button) => (
              <ListItem
                button
                onClick={!isBigScreen ? handleDrawerClose : () => null}
                key={button.text}
                component={Link}
                {...{ to: button.path }}
              >
                <ListItemIcon>{button.icon}</ListItemIcon>
                <ListItemText primary={button.text} />
              </ListItem>
            ))}
          </List>
        </Box>
      ))}
    </Drawer>
  );
}

export default Leftbar;
