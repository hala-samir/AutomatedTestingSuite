package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private By addToCartBtn = By.xpath("//a[normalize-space()='Add to cart']");
    private  By pageTitle = By.xpath("//h2[@class='name']");

    public void clickAddToCartBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        clickBtn(addToCartBtn);
    }
}
