type SideMenuOptions = {
  sections: {
    sectionName: string;
    buttons: {
      text: string;
      icon: JSX.Element;
      path: string;
    }[];
  }[];
};
