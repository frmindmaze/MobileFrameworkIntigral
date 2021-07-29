package com.intigral.stepdefs;

import com.intigral.Pages.LoginPage;
import com.intigral.Pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Product {
    ProductPage productPage = new ProductPage();

    @When("^user click on the add to cart button in product page$")
    public void addCartProduct() throws InterruptedException {
        productPage.clickAddCartBtn();

    }

    @When("^user click on the remove button in product page$")
    public void removeCartProduct() throws InterruptedException {
        productPage.clickRemoveCartBtn();
    }

    @Then("^verify add to cart button is visible")
    public void verifyaddcartbtn(){
        productPage.isAddToCartBtnDisplayed();
    }

    @Then("^verify (.+) product added to the cart")
    public void verifyNumberofProducts(String value) throws Exception {
        String noOfItems= productPage.verifyCartitems();
        Assert.assertEquals(noOfItems, value);
    }


    @Then("^verify the product details page with product (.+), price (.+) and description (.+)$")
    public void verifyProductDetails(String product, String price, String desc) throws Exception {
        boolean titleCheck = productPage.getTitle().equalsIgnoreCase(product);
        boolean descCheck = productPage.getDesc().equalsIgnoreCase(desc);
        boolean priceCheck = productPage.getPrice().equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
                titleCheck & descCheck & priceCheck);
    }
}
