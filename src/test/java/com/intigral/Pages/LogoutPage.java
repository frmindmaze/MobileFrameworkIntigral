package com.intigral.Pages;

import com.intigral.CommonActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogoutPage extends CommonActions {
    public static LogoutPage instance;

    public static LogoutPage getInstance() {
        if (instance == null) {
            synchronized (LogoutPage.class) {
                if (instance == null) {
                    instance = new LogoutPage();
                }
            }
        }
        return instance;
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView\n" +
            "")
    private MobileElement MenuBtn;

    @AndroidFindBy(accessibility = "test-LOGOUT")
    private MobileElement logoutBtn;


    public void pressMenuBtn() {
        click(MenuBtn, "press Settings button");
    }


    public LoginPage pressLogoutBtn() {
        click(logoutBtn, "press Logout button");
        return new LoginPage();
    }
}
