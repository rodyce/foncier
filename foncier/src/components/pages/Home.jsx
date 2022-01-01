import React from 'react';
import {
  Button, Grid, Link, Paper, Typography, Box,
} from '@mui/material';

const styles = {
  loginForm: {
    justifyContent: 'center',
    minHeight: '90vh',
  },
  buttonBlock: {
    width: '100%',
  },
  loginBackground: {
    justifyContent: 'center',
    maxHeight: '30vh',
    minHeight: '150px',
    padding: '25px',
  },
};

function Home({ loggedIn, setLoggedIn }) {
  const handleLogout = () => {
    setLoggedIn(false);
  };

  return (
    <Box sx={{
      width: '100%',
      height: '100%',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
    }}
    >
      <Grid container spacing={0} justify="center" direction="row">
        <Grid item sx={{ margin: '0 auto', paddingLeft: ['5%', null, null, 0] }}>
          <Grid
            container
            direction="column"
            justify="center"
            spacing={2}
            sx={styles.loginForm}
          >
            <Paper
              variant="elevation"
              elevation={2}
              sx={styles.loginBackground}
            >
              <Grid item sx={{ marginBottom: 3 }}>
                <Typography component="h1" variant="h5" sx={{ textAlign: 'center' }}>
                  FONCIER APP
                </Typography>
                <Typography component="h2" variant="h5" sx={{ textAlign: 'center' }}>
                  Sign Out
                </Typography>
              </Grid>
              <Grid item>
                <Grid container direction="column" spacing={5}>
                  <Grid item>
                    <Button
                      variant="contained"
                      color="primary"
                      type="submit"
                      sx={styles.buttonBlock}
                      onClick={handleLogout}
                    >
                      Log out
                    </Button>
                  </Grid>
                </Grid>
              </Grid>
              <Grid item>
                <Link href="https://reactjs.org/" target="_blank" variant="body2">
                  Learn more
                </Link>
                <Typography fontSize={[9, '!important']}>
                  {loggedIn ? 'Logged in' : ''}
                </Typography>
              </Grid>
            </Paper>
          </Grid>
        </Grid>
      </Grid>
    </Box>
  );
}

export default Home;
