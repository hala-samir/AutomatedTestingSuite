package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class PageBase {
    public static WebDriver driver;
    public JavascriptExecutor js;
    public static WebDriverWait wait;
    public Actions action;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    public static void clickBtn(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public static void clearTxt(WebElement element) {
        element.clear();
    }

    public static void fillTextField(WebElement element, String txt) {
        wait.until(ExpectedConditions.visibilityOf(element));
        clearTxt(element);
        element.sendKeys(txt);
    }

    public static void fillTextField(By element, String txt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        fillTextField(driver.findElement(element), txt);
    }

    public String getAlertText() {
       wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String getTextValue(By element) {
        return driver.findElement(element).getText();
    }

    public void dismissDisplayedAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean isElementDisplayed(By element){
       return driver.findElement(element).isDisplayed();
    }
}
