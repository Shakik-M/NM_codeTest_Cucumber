package stepDef;

import base.setUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class shoppingStep extends setUp {

    login login = new login(driver);
    inventory inventory = new inventory(driver);
    cart cart = new cart(driver);
    userInfo userInfo = new userInfo(driver);
    checkout checkout = new checkout(driver);
    shoppingComplete shoppingComplete = new shoppingComplete(driver);

    @Given("I am at the SauceDemo homepage")
    public void iAmAtTheSauceDemoHomepage() {
        login.verifyHomepageTitle();
    }

    @And("I login entering valid user credentials")
    public void iLoginEnteringValidUserCredentials() {
        login.enterUserName(Hook.userName);
        login.enterPassword(Hook.password);
    }

    @When("I click on Login Button")
    public void iClickOnLoginButton() {
        login.clickLoginButton();
    }

    @Then("I should be landing into inventory page and able to sort the items by price from Low to high")
    public void iShouldBeLandingIntoInventoryPageAndAbleToSortTheItemsByPriceFromLowToHigh() {
        inventory.sortLowtoHigh();
    }

    @When("I click on the add to cart buttons of items")
    public void iClickOnTheAddToCartButtonsOfItems() {
        inventory.addItem1toCart();
        inventory.addItem2toCart();
        inventory.addItem3toCart();
    }

    @Then("I should be able to view the items in cart")
    public void iShouldBeAbleToViewTheItemsInCart() {
        inventory.gotoCart();
        cart.assertCartItems();
    }

    @And("I can remove the items from cart")
    public void iCanRemoveTheItemsFromCart() {
        cart.removeItem();
    }

    @And("I can add another item in cart by going back to inventory page")
    public void iCanAddAnotherItemInCartByGoingBackToInventoryPage() {
        cart.continueShopping();
        inventory.addItem4toCart();
    }

    @And("I click on the checkout button in my cart page")
    public void iClickOnTheCheckoutButtonInMyCartPage() {
        inventory.gotoCart();
        cart.cartToCheckout();
    }

    @And("I enter my first name, last name, zipcode")
    public void iEnterMyFirstNameLastNameZipcode() {
        userInfo.enterFirstName(Hook.firstName);
        userInfo.enterLastName(Hook.lastName);
        userInfo.enterPostalCode(Hook.postalCode);
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        userInfo.continueChkOutButton();
    }

    @And("I can verify the purchased item and total price")
    public void iCanVerifyThePurchasedItemAndTotalPrice() {
        checkout.assertCheckOutItems();
        checkout.assertTotalPrice();
    }

    @When("I click on finish button")
    public void iClickOnFinishButton() {
        checkout.clickFinishBtn();
    }

    @Then("I should be able to complete the shopping")
    public void iShouldBeAbleToCompleteTheShopping() {

    }



}
