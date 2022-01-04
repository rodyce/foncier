import * as React from "react";

export interface LoginContextInterface {
  loggedIn: boolean;
  setLoggedIn: React.Dispatch<React.SetStateAction<boolean>>;
}

const LoginContext = React.createContext<LoginContextInterface>(
  {} as LoginContextInterface
);

export default LoginContext;
