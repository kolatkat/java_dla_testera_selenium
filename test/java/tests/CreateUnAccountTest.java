package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.CreateUnAccountPage;
import pages.TopMenuPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUnAccountTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private CreateUnAccountPage createUnAccountPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        createUnAccountPage = new CreateUnAccountPage(driver);
    }

    @Test
    public void shouldICreateUnAccount() {
        topMenuPage.clickOnSignInLink();
        createUnAccountPage.enterEmail("kasiakskaksaksak@test.pl");
        createUnAccountPage.pressCreateUnAccountButton();
    }

}
