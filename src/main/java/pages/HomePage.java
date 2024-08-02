package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage  extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    static Faker faker = new Faker();
    private By  loginBtn = By.id("login2");
    private By userNameLoginField = By.id("loginusername");
    private By passwordLoginField = By.id("loginpassword");
    private By loginModelBtn = By.xpath("//button[normalize-space()='Log in']");
    private By displayedUsername = By.id("nameofuser");

    private By signUpBtn = By.id("signin2");
    private By userNameSignUpField = By.id("sign-username");
    private By passwordSignUpField = By.id("sign-password");
    private By signUpModelBtn =By.xpath("//button[normalize-space()='Sign up']");
    private By firstDisplayedItem = By.xpath("(//h4[@class='card-title'])[1]");

    private By contactLink = By.xpath("//a[normalize-space()='Contact']");
    private By logoutBtn = By.id("logout2");

    private static String userName = faker.internet().emailAddress();
    private static String password = faker.internet().password();

    private String categoriesGenericLocator = "//a[normalize-space()='%s']";

    public void clickSignUpBtn(){
//       action.moveToElement(driver.findElement(signUpBtn)).click().perform();
       clickBtn(signUpBtn);
    }

    public void fillSignUpModalData(){
        fillTextField(userNameSignUpField, userName);
        fillTextField(passwordSignUpField, password);
    }

    public void clickSignUpBtnModel(){
        action.moveToElement(driver.findElement(signUpModelBtn)).click().perform();
//        clickBtn(signUpModelBtn);
    }

    public void clickLoginBtn(){
        clickBtn(loginBtn);
    }

    public void fillLoginModalData(){
        fillTextField(userNameLoginField, userName);
        fillTextField(passwordLoginField, password);
    }

    public void clickLoginBtnModel(){
        clickBtn(loginModelBtn);
    }

    public boolean isCorrectUserNameDisplayed(){
         return getTextValue(displayedUsername).equalsIgnoreCase(userName);
    }

    public void clickFirstDisplayedItem(){
        clickBtn(firstDisplayedItem);
    }

    public By returnCategoriesGenericLocator(String categoryName){
        return By.xpath(String.format(categoriesGenericLocator, categoryName));
    }

    public void clickCategoriesGenericLocator(String categoryName){
        By element = returnCategoriesGenericLocator(categoryName);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));
        clickBtn(returnCategoriesGenericLocator(categoryName));
    }

    public void clickContactLink(){clickBtn(contactLink);
    }

    public void clickLogoutBtn(){
        refreshScreen();
        clickBtn(logoutBtn);
    }

    public boolean isSignUpBtnDisplayed(){

        return isElementDisplayed(signUpBtn);
    }

    public void refreshScreen(){
        driver.navigate().refresh();
    }
}
