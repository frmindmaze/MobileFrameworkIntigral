package com.intigral.stepdefs;


import com.intigral.Pages.Homepage;
import com.intigral.Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login {



    @When("^user enter the username as (.+)$")
    public void enterUserName(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);

    }

    @When("^user enter the password as (.+)$")
    public void enterPassword(String password) throws InterruptedException {
        new LoginPage().enterPassword(password);
    }

    @When("^user click on the login button$")
    public void Login() {
        new LoginPage().clickLoginBtn();

    }

    @When ("^user login to the app with user (.+) and pass (.+)$")
    public void AppLogin(String user,String pass) throws InterruptedException {
        LoginPage.getInstance().login(user,pass);
    }

    @Then("^verify login failed with error message (.+)$")
    public void verifyErrorLogin(String err) throws Exception {
        Assert.assertEquals(new LoginPage().getErrMsg(), err);
    }

    @Then("^verify homepage is displayed with title (.+)$")
    public void verifyTitle(String title) throws Exception {
        Assert.assertEquals(new Homepage().getTitle(), title);
    }


}
