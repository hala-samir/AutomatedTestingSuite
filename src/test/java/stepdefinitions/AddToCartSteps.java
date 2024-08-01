package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AddToCartSteps extends TestBase{
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);;

    @Given("user clicks {string} category")
    public void userClicksCategory(String categoryName) {
        homePage.clickCategoriesGenericLocator(categoryName);
    }

    @When("user clicks the first displayed item")
    public void userClicksTheFirstDisplayedItem() {
        homePage.clickFirstDisplayedItem();
    }

    @Then("the item is added to the cart")
    public void theItemIsAddedToTheCart(){
        productPage.clickAddToCartBtn();
        assertThat(homePage.getAlertText().equalsIgnoreCase("Product added."));
        homePage.dismissDisplayedAlert();
    }
}
