package stepdefinitions;


import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeSteps extends TestBase {
    HomePage homePage = new HomePage(driver);;

    @Given("user is in home page")
    public void userIsInHomePage(){
        homePage.clickSignUpBtn();
    }

    @When("user fills the required data")
    public void userFillsTheRequiredData() {
        homePage.fillSignUpModalData();
    }

    @Then("user clicks register")
    public void userClicksRegister() {
        homePage.clickSignUpBtnModel();
        assertThat(homePage.getAlertText().equalsIgnoreCase("Sign up successful."));
        homePage.dismissDisplayedAlert();
    }

    @Given("user enters correct username and password")
    public void userEnterCorrectUsernameAndPassword() {
        homePage.clickLoginBtn();
        homePage.fillLoginModalData();
        homePage.clickLoginBtnModel();
    }

    @Then("user logs in successfully")
    public void userLogInSuccessfully() {
        homePage.isCorrectUserNameDisplayed();
    }

}
