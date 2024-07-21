package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class LogoutSteps extends TestBase {
    HomePage homePage = new HomePage(driver);

    @Given("user clicks logout")
    public void userClicksLogout() {
        homePage.clickLogoutBtn();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        assertThat(homePage.isSignUpBtnDisplayed()).isTrue();
    }
}
