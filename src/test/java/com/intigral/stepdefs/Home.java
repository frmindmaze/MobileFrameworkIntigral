package com.intigral.stepdefs;


import com.intigral.Pages.AddCartPage;
import com.intigral.Pages.Homepage;
import com.intigral.Pages.LoginPage;
import com.intigral.Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Home {


    @Then("^verify the product is listed in the home page with name (.+) and price (.+)$")
    public void verifyProductTitleAndPrice(String product, String price) throws Exception {
        Boolean productvalue = new Homepage().getProductTitle(product).equalsIgnoreCase(product);
        Boolean pricevalue = new Homepage().getProductPrice(product, price).equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + productvalue + ", priceCheck = " + pricevalue,
                productvalue & pricevalue);
    }

    @When("^user click on the product (.+)$")
    public void clickProductTitle(String product) throws Exception {
        Homepage.getInstance().ClickProductBylink(product);
    }

    @When ("^user add the product (.+) from homepage$")
    public void addProductFromHome(String product) throws Exception {
        Homepage.getInstance().AddProductByName(product);
        Homepage.getInstance().HomeClickCartIcon();
    }



}
