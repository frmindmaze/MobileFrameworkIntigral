package com.intigral.Pages;

import com.intigral.CommonActions;
import com.intigral.appium.AppiumParams;
import com.intigral.stepdefs.Home;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class Homepage extends CommonActions {
    public static Homepage instance;

    public static Homepage getInstance() {
        if(instance == null){
            synchronized (Homepage.class){
                if(instance == null){
                    instance= new Homepage();
                }
            }
        }
        return instance;
    }


    @AndroidFindBy(xpath = "//*[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView\n")
    private MobileElement titleTxt;


    @AndroidFindBy(xpath = "//*[@content-desc=\"test-Cart\"]/android.view.ViewGroup\n")
    private MobileElement AddCartIcon;

    private By ProdNametoCart;

//

    public String getTitle() throws Exception {
        return getText(titleTxt, "Home page title is - ");
    }

    public String getProductTitle(String title) throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                return getText(andScrollToElementUsingUiScrollable("text", title), "Product title is: " + title);
            case "iOS":

            default:
                throw new Exception("Please choose Android or iOS");
        }
    }

    public By ProductPrice(String title) throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
            case "iOS":
            default:
                throw new Exception("Invalid platform name");
        }
    }

    public String getProductPrice(String title, String price) throws Exception {
        return getText(scrollToElement(ProductPrice(title), "up"), "product price is: " + price);
    }

    public Homepage AddProductByName(String prodName) throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                click(By.xpath("//*[@text=\""+prodName+"\"]/parent::android.view.ViewGroup//following-sibling::*[@content-desc=\"test-ADD TO CART\"]"), "Click AddToCart button by product");
                return this;
            case "iOS":

            default:
                throw new Exception("Invalid platform name");
        }
    }

    public AddCartPage ClickProductBylink(String title) throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
                return new AddCartPage();
            case "iOS":

            default:
                throw new Exception("Invalid platform name");
        }
    }

    public AddCartPage HomeClickCartIcon() throws Exception {
        switch (new AppiumParams().getPlatformName()) {
            case "Android":
                click(AddCartIcon,"Click on the Cart Icon");
                return new AddCartPage();
            case "iOS":

            default:
                throw new Exception("Invalid platform name");
        }
    }

}

