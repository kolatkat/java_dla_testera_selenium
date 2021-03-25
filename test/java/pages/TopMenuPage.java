package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
    WebElement myCustomerAccount;

    @FindBy(linkText = "Sign out")
    WebElement signOut;

    public void clickOnContactUsLink() {
        contactUsLink.click();

    }

    public void clickOnSignInLink() {
        signInLink.click();

    }

    public String MyAccountName() {
        return myCustomerAccount.getText();
    }

    public boolean isSignOutDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signOut));

        boolean isDisplayed = false;
        try {
            isDisplayed = signOut.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }

    public void clickOnSignOutLink() {
        signOut.click();
    }
}

