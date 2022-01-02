import * as React from "react";
import { useState, useMemo } from "react";
import DashboardContainer from "./components/DashboardContainer";
import LoginContext, { LoginContextInterface } from "./LoginContext";
import Login from "./components/Login";

function App() {
  const [loggedIn, setLoggedIn] = useState<boolean>(false);

  const contextValue = { loggedIn, setLoggedIn };

  const layout = !loggedIn ? <Login /> : <DashboardContainer title="Foncier" />;

  return (
    <LoginContext.Provider value={contextValue}>{layout}</LoginContext.Provider>
  );
}

export default App;
