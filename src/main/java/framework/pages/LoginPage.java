package framework.pages;

import framework.driver.DriverManager;

public class LoginPage {
    String button_continue="text=Continue";

    public LoginPage clickNewContusomer(){
        DriverManager.getPage().click(button_continue);
        return this;
    }

    public String getTitle(){
       return DriverManager.getPage().title();
    }
}
