package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.ContactPage;
import pages.HomePage;
import utilities.JSONReader;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactMessageSteps extends TestBase{
    HomePage homePage = new HomePage(driver);
    ContactPage contactPage = new ContactPage(driver);
    JSONReader jsonReader = new JSONReader();

    @Given("user clicks the contact link")
    public void userClicksTheContactLink() {
        homePage.clickContactLink();
    }

    @When("user fills the contact data")
    public void userFillsTheContactData() throws IOException, ParseException {
        String email = jsonReader.readJson("contactMsgData.json", "email");
        String name = jsonReader.readJson("contactMsgData.json", "name");
        String msg = jsonReader.readJson("contactMsgData.json", "message_text");
        contactPage.fillContactEmailTxtField(email);
        contactPage.fillContactNameTxtField(name);
        contactPage.fillMessageTxtField(msg);
        contactPage.clickSendMsgBtn();
    }

    @Then("the message is sent successfully")
    public void theMessageIsSentSuccessfully()  {
        assertThat(homePage.getAlertText().equalsIgnoreCase("Thanks for the message!!"));
        homePage.dismissDisplayedAlert();
    }
}
