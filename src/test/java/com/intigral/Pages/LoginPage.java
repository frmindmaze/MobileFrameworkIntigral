package com.intigral.Pages;

import com.intigral.CommonActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends CommonActions {

    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement usernameTxtFld;

    @AndroidFindBy (accessibility = "test-Password")
    private MobileElement passwordTxtFld;

    @AndroidFindBy (accessibility = "test-LOGIN")
    private MobileElement loginBtn;

    @AndroidFindBy (xpath = "//*[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private MobileElement errorMsg;

    public LoginPage(){
    }

    public LoginPage enterUserName(String username) throws InterruptedException {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld, username, "login with username " + username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld, password, "Entered password is " + password);
        return this;
    }

    public Homepage pressLoginBtn() {
        click(loginBtn, "Click login button");
        return new Homepage();
    }

    public Homepage login(String username, String password) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrMsg() {
        String err = getText(errorMsg, "error message is - ");
        return err;
    }

}
