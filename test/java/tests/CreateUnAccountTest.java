package tests;

import enums.Gender;
import model.Address;
import model.PersonalForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateUnAccountPage;
import pages.PersonalFormPage;
import pages.TopMenuPage;
import utils.PageTitleUtils;
import utils.RandomPersonalData;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUnAccountTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private CreateUnAccountPage createUnAccountPage;
    private PersonalFormPage personalFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        createUnAccountPage = new CreateUnAccountPage(driver);
        personalFormPage = new PersonalFormPage(driver);
    }

    @Test
    public void shouldCreateAccountWithPropreData() {
        topMenuPage.clickOnSignInLink();

        Address address = new Address();
        address.setAddress1("Kubusia Puchatka");
        address.setCity("Poznań");
        address.setZip("00890");
        address.setState("4");

        PersonalForm personalForm = new PersonalForm();
        personalForm.setGender(Gender.Mrs);
        personalForm.setCustomerFirstName("Kasia");
        personalForm.setCustomerLastName("Testowacik");
        personalForm.setEmail(RandomPersonalData.EmailAddress());
        personalForm.setMobilephone("888789789");
        personalForm.setAlias("kasia@test.pl");
        personalForm.setPassword("3edc456^");
        personalForm.setAddress(address);
        personalForm.setBirthday("1");
        personalForm.setBirthmonth("1");
        personalForm.setBirthyear("1995");

        createUnAccountPage.enterEmail(personalForm.getEmail());
        createUnAccountPage.pressCreateUnAccountButton();
        personalFormPage.checkTheTitleBox(personalForm.getGender().getValue());
        personalFormPage.sendCreateAccountForm(driver,personalForm);

        Assertions.assertThat(topMenuPage.isSignOutDisplayed()).isTrue();

        topMenuPage.clickOnSignOutLink();

    }

}