package pages;

import model.PersonalForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PersonalFormPage extends BasePage {
    public PersonalFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "id_gender")
    List<WebElement> genders;

    @FindBy(id = "id_gender2")
    WebElement genderMrs;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement birthDay;

    @FindBy(id = "months")
    WebElement birthMonth;

    @FindBy(id = "years")
    WebElement birthYear;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement idState;

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "id_country")
    WebElement idCountry;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;

    @FindBy(id = "alias")
    WebElement alias;

    @FindBy(id = "submitAccount")
    WebElement submitAccount;

    public void checkTheTitleBox(String gender) {
        for (WebElement type : genders) {
            if (type.getAttribute("value").equals(gender)) {
                if (!type.isSelected()) {
                    type.click();
                }
            }
        }
    }

    public void sendCreateAccountForm(WebDriver driver, PersonalForm personalForm) {
        wait.until(ExpectedConditions.visibilityOf(birthDay));

        Select dayOfBirth = new Select(birthDay);
        dayOfBirth.selectByValue(personalForm.getBirthday());

        Select monthOfBirth = new Select(birthMonth);
        monthOfBirth.selectByValue(personalForm.getBirthmonth());

        Select yearOfBirth = new Select(birthYear);
        yearOfBirth.selectByValue(personalForm.getBirthyear());

        Select state = new Select(idState);
        state.selectByValue(personalForm.getAddress().getState());

        customerFirstName.sendKeys(personalForm.getCustomerFirstName());
        customerLastName.sendKeys(personalForm.getCustomerLastName());
        password.sendKeys(personalForm.getPassword());

        MoveToElement(driver, address1);
        address1.sendKeys(personalForm.getAddress().getAddress1());
        city.sendKeys(personalForm.getAddress().getCity());
        postCode.sendKeys(personalForm.getAddress().getZip());
        phoneMobile.sendKeys(personalForm.getMobilephone());
        alias.sendKeys(personalForm.getAlias());
        submitAccount.click();
    }
}

