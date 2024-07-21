package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends PageBase{
    public ContactPage(WebDriver driver) {
        super(driver);
    }
    private By contactEmailTxtField = By.id("recipient-email");
    private By contactNameTxtField = By.id("recipient-name");
    private By messageTxtField = By.id("message-text");
    private By sendMsgBtn = By.xpath("//button[normalize-space()='Send message']");

    public void fillContactEmailTxtField(String email){
        fillTextField(contactEmailTxtField, email);
    }

    public void fillContactNameTxtField(String name){
        fillTextField(contactNameTxtField, name);
    }

    public void fillMessageTxtField(String msg){
        fillTextField(messageTxtField, msg);
    }

    public void clickSendMsgBtn(){
        clickBtn(sendMsgBtn);
    }
}
