package com.intigral.Pages;

import com.intigral.CommonActions;
import com.intigral.appium.AppiumParams;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends CommonActions {

    public static ProductPage instance;

    public static ProductPage getInstance() {
        if(instance == null){
            synchronized (ProductPage.class){
                if(instance == null){
                    instance= new ProductPage();
                }
            }
        }
        return instance;
    }


    @AndroidFindBy(xpath = "//*[@content-desc=\"test-Description\"]/android.widget.TextView[1]\n" +
            "")
    private MobileElement title;

    @AndroidFindBy (xpath = "//*[@content-desc=\"test-Description\"]/android.widget.TextView[2]"
            + "")
    private MobileElement desc;

    @AndroidFindBy (accessibility = "test-BACK TO PRODUCTS")
    private MobileElement backToProductsBtn;

    @AndroidFindBy (accessibility = "test-REMOVE")
    private MobileElement removeCartBtn;

    @AndroidFindBy (accessibility = "test-ADD TO CART")
    private MobileElement addToCartBtn;

    @AndroidFindBy (xpath = "//*[@content-desc=\"test-Cart\"]//android.widget.TextView")
    private MobileElement noOfCartItems;

    public String getTitle() throws Exception {
        return getText(title, "title is: ");
    }

    public String getDesc() throws Exception {
        return getText(desc, "description is: ");
    }

    public String getPrice() throws Exception {
        switch(new AppiumParams().getPlatformName()){
            case "Android":
                return getText(andScrollToElementUsingUiScrollable("description", "test-Price"), "price is: ");
            case "iOS":
            default:
                throw new Exception("Invalid platform name");
        }
    }

    public Boolean isAddToCartBtnDisplayed() {
        return addToCartBtn.isDisplayed();
    }

    public ProductPage clickAddCartBtn(){
        click(addToCartBtn, "add product to the cart");
        return this;
    }

    public ProductPage clickRemoveCartBtn(){
        click(removeCartBtn, "remove product from the cart");
        return this;
    }

    public String verifyCartitems() throws Exception {
        String value =getText(noOfCartItems, "get no of cart items ");
        return value;
    }


    public Homepage pressBackToProductsBtn() {
        click(backToProductsBtn, "navigate back to products page");
        return new Homepage();
    }

}
