package com.intigral.Pages;

import com.intigral.CommonActions;
import com.intigral.appium.AppiumParams;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddCartPage extends CommonActions {

    public static AddCartPage instance;

    public static AddCartPage getInstance() {
        if(instance == null){
            synchronized (AddCartPage.class){
                if(instance == null){
                    instance= new AddCartPage();
                }
            }
        }
        return instance;
    }

    @AndroidFindBy(xpath = "//*[@content-desc=\"test-Menu\"]//parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView" +
            "")
    private MobileElement Pagetitle;
    @AndroidFindBy (xpath = "//*[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private MobileElement title;

    @AndroidFindBy (xpath = "//*[@content-desc=\"test-Description\"]/android.widget.TextView[2]"
            + "")
    private MobileElement desc;

    @AndroidFindBy (xpath = "//*[@content-desc=\"test-Price\"]/android.widget.TextView")
    private MobileElement price;

    @AndroidFindBy (accessibility = "test-CONTINUE SHOPPING")
    private MobileElement ContinueShoppingBtn;


    @AndroidFindBy (accessibility = "test-CHECKOUT") private MobileElement CheckOutBtn;



    public String getTitle() throws Exception {
        return getText(title, "title is: ");
    }

    public String getDesc() throws Exception {
        return getText(desc, "description is: ");
    }

    public String getPrice() throws Exception {
        switch(new AppiumParams().getPlatformName()){
            case "Android":
                return getText(price, "price is: ");
            case "iOS":
            default:
                throw new Exception("Invalid platform name");
        }
    }

    public AddCartPage ClickCheckoutBtn() {
        click(CheckOutBtn, "navigate back to Checkout page");
        return new AddCartPage();
    }

    public Homepage ClickContinueShopBtn() {
        click(ContinueShoppingBtn, "navigate back to Home page");
        return new Homepage();
    }
}
