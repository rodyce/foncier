import React, { useContext } from 'react';
import { styled } from '@mui/material/styles';
import { Box } from '@mui/material';
import { Route, Switch, Redirect } from 'react-router-dom';
import { Home } from './pages';
import LoginContext from '../LoginContext';

const ContainerHeader = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'flex-end',
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
}));

function Feed() {
  const { loggedIn, setLoggedIn } = useContext(LoginContext);

  return (
    <Box component="main" sx={{ flexGrow: 1, p: 3, width: 'calc(100vw - 240px)' }}>
      <ContainerHeader />
      <Switch>
        <Route exact path="/">
          <Home loggedIn={loggedIn} setLoggedIn={setLoggedIn} />
        </Route>
        <Redirect from="*" to="/" />
      </Switch>
    </Box>
  );
}

export default Feed;
