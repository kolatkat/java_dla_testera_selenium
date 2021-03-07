package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUnAccountPage extends BasePage {
    public CreateUnAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    WebElement createUnAccountButton;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void pressCreateUnAccountButton() {
        createUnAccountButton.click();
    }
}
