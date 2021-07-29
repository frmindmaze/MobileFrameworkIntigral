package com.intigral.Pages;

import com.intigral.CommonActions;
import com.intigral.appium.AppiumParams;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.NoSuchElementException;

public class CheckoutPage extends CommonActions {

    public static CheckoutPage instance;

    public static CheckoutPage getInstance() {
        if (instance == null) {
            synchronized (CheckoutPage.class) {
                if (instance == null) {
                    instance = new CheckoutPage();
                }
            }
        }
        return instance;
    }

    @AndroidFindBy(xpath = "//*[@content-desc=\"test-Menu\"]//parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement Pagetitle;

    @AndroidFindBy(accessibility = "test-First Name")
    private MobileElement FirstName;

    @AndroidFindBy(accessibility = "test-Last Name")
    private MobileElement LastName;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private MobileElement Zipcode;

    @AndroidFindBy(accessibility = "test-CANCEL")
    private MobileElement CancelBtn;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private MobileElement ContinueBtn;

    @AndroidFindBy(accessibility = "test-FINISH")
    private MobileElement FinishBtn;

    @AndroidFindBy(xpath = "//*[@text=\"Payment Information:\"]//following-sibling::android.widget.TextView[1]")
    private MobileElement PaymentInfo;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[4]")
    private MobileElement ShippingInfo;

    @AndroidFindBy(xpath = "//*[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]")
    private MobileElement Itemtotal;

    @AndroidFindBy(xpath = "//*[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[6]")
    private MobileElement tax;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]")
    private MobileElement FinalTotal;

//    @AndroidFindBy(id = "")
//    private MobileElement CheckoutComplete;

    @AndroidFindBy(accessibility = "test-BACK HOME")
    private MobileElement BacktoHome;

    @AndroidFindBy(xpath = "//*[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    private MobileElement OrderConfirmMsg;


    public String getTitle() throws Exception {
        return getText(Pagetitle, "title is: ");
    }

    public Homepage clickBackhome() throws Exception {
        scrollToElement(BacktoHome,"up");
        click(BacktoHome);
        return new Homepage();
    }


    public CheckoutPage fillCheckoutInfo(String fName, String lName, String Pincode) {
        sendKeys(FirstName, fName, "Enter firstName");
        sendKeys(LastName, lName, "Enter lastName");
        sendKeys(Zipcode, Pincode, "Enter Pincode");
        click(ContinueBtn);
        return this;
    }

    public String getPaymentInfo() throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                return getText(PaymentInfo, "");
            case "iOS":

            default:
                throw new Exception("Please choose Android or iOS");
        }
    }

    public String getShippingInfo() throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                return getText(ShippingInfo, "");
            case "iOS":

            default:
                throw new Exception("Please choose Android or iOS");
        }
    }

    public String getTotal() throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":

                return getText(FinalTotal, "");

            case "iOS":

            default:
                throw new Exception("Please choose Android or iOS");
        }
    }

    public String orderConfMsg() throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                return getText(OrderConfirmMsg, "");
            case "iOS":

            default:
                throw new Exception("Please choose Android or iOS");
        }
    }

    public void ClickfinishBtn() throws Exception {
        scrollToElement(FinishBtn,"up");
        click(FinishBtn);
    }


}
