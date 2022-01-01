import React, { useState, useMemo } from 'react';
import DashboardContainer from './components/DashboardContainer';
import LoginContext from './LoginContext';
import Login from './components/Login';

function App() {
  const [loggedIn, setLoggedIn] = useState();

  const contextValue = useMemo(() => ({ loggedIn, setLoggedIn }));

  const layout = !loggedIn
    ? (<Login />)
    : (<DashboardContainer title="Foncier" />);

  return (
    <LoginContext.Provider value={contextValue}>
      {layout}
    </LoginContext.Provider>
  );
}

export default App;
