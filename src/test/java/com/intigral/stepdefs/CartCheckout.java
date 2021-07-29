package com.intigral.stepdefs;

import com.intigral.CommonActions;
import com.intigral.Pages.AddCartPage;
import com.intigral.Pages.CheckoutPage;
import com.intigral.Pages.Homepage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartCheckout {


    @Then("^verify the product is listed in the cart page with name (.+) and price (.+)$")
    public void verifyProductTitleAndPrice(String product, String price) throws Exception {
        Boolean productvalue = new Homepage().getProductTitle(product).equalsIgnoreCase(product);
        Boolean pricevalue = new AddCartPage().getPrice().equalsIgnoreCase(price);
        Assert.assertTrue("Product = " + productvalue + ", price = " + pricevalue,
                productvalue & pricevalue);
    }


    @When("^user click on the Checkout in the cart$")
    public void clickProductTitle() throws Exception {
        AddCartPage.getInstance().ClickCheckoutBtn();
    }

    @When("^user enter the checkout details with firstname (.+), lastname (.+) and zipcode (.+) and continue$")
    public void fillcheckouttdtls(String fname, String lname, String zip) {
        CheckoutPage.getInstance().fillCheckoutInfo(fname, lname, zip);

    }

    @Then("^verify the order info with paymentInfo (.+), Shipping (.+) and total (.+)$")
    public void verifyProductDetails(String payment, String shipping, String total) throws Exception {
        boolean paymentinfo = CheckoutPage.getInstance().getPaymentInfo().equalsIgnoreCase(payment);
        boolean ShippingInfo = CheckoutPage.getInstance().getShippingInfo().equalsIgnoreCase(shipping);
        boolean payTotal = CheckoutPage.getInstance().getTotal().contains(total);
        Assert.assertTrue("paymentinfo = " + paymentinfo + ", ShippingInfo = " + ShippingInfo + ", priceCheck = " + payTotal,
                paymentinfo & ShippingInfo & payTotal);
    }

    @When("^user click on the finish button in the checkout")
    public void clickFinish() throws Exception {
        CheckoutPage.getInstance().ClickfinishBtn();
    }

    @Then("^verify the order sucess msg (.+) is displayed$")
    public void verifyOrder(String msg) throws Exception {
        boolean ordersucessmsg = CheckoutPage.getInstance().orderConfMsg().equalsIgnoreCase(msg);
        Assert.assertTrue("Msg = " + msg,
                ordersucessmsg);
        CheckoutPage.getInstance().clickBackhome();
    }


}


