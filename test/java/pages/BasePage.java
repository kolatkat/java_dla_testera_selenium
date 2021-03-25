package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Base64;

public class BasePage {

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void MoveToElement(WebDriver driver, WebElement element)
    {
        Actions builder = new Actions(driver);
        Actions moveTo = builder.moveToElement(element);
        moveTo.build().perform();
    }
}
