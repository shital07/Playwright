package framework.pages;

import framework.driver.Driver;
import framework.driver.DriverManager;

public class HomePage {


    String textbox_search = "input[name='search']";
    //   "input#twotabsearchtextbox";
    String icon_search = "button.btn.btn-default.btn-lg";
    //  "input#nav-search-submit-button";


    String search_result_header = "div#content h1";

    String link_my_account = "span:has-text('My Account')";
    String link_login = "text=Login";


    public void enterSearchText(String text) {

        Driver.getPage().locator(textbox_search).fill(text);

    }

    public void clickSearchIcon() {

        Driver.getPage().click(icon_search);

    }

    public String getSearchHeading() {

        return Driver.getPage().textContent(search_result_header);

    }

    public LoginPage clickMyAccountlink() {

        DriverManager.getPage().click(link_my_account);
        DriverManager.getPage().click(link_login);
        return new LoginPage();


    }


}
