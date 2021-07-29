package com.intigral.stepdefs;

import com.intigral.Pages.LogoutPage;
import io.cucumber.java.en.When;

public class Logout {

    @When("^user click on the Logout button$")
    public void Logout() {
        LogoutPage.getInstance().pressMenuBtn();
        LogoutPage.getInstance().pressLogoutBtn();


    }
}
