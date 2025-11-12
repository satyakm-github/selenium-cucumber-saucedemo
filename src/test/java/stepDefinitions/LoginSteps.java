package stepDefinitions;

import Utils.DriverUtils;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;


    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(DriverUtils.driver);
        loginPage.url("https://www.saucedemo.com/");
    }

    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {

        loginPage.loginButton();
    }

    @Then("user navigates to Products page")
    public void user_navigates_to_products_page() {
        String title = loginPage.getTitle();
        Assert.assertTrue(title.contains("Products"));
        System.out.println(title);

    }
    @When("user selects the highest priced items to add to cart")
    public void user_selects_the_highest_priced_items_to_add_to_cart() {

        loginPage.addHighestItemsToCart();

    }
    @Then("user verifies the cart should contain the selected product")
    public void user_verifies_the_cart_should_contain_the_selected_product() {

        loginPage.cartButton();
        boolean itemInCart = loginPage.isHighestItemInCart();
        if(! itemInCart){
            throw new AssertionError("Product not found in the cart");

        }
    }
}
