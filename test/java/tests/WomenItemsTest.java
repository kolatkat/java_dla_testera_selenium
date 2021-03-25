package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CategoryPage;
import pages.PopularItemsPage;
import pages.SearchResultsPage;
import pages.WomenItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WomenItemsTest extends BaseTest {

    private CategoryPage categoryPage;
    private WomenItemsPage womenItemsPage;
    private SearchResultsPage searchResultsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        categoryPage = new CategoryPage(driver);
        womenItemsPage = new WomenItemsPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void shouldAllWomenItemsHavePriceGreaterThanZero() {
        categoryPage.clickOnWomenItems();
        List<Float> productPrices = womenItemsPage.getPrices();

        List<Float> productWithPriceZero = productPrices.stream()
                .filter(el -> el == 0.0)
                .collect(Collectors.toList());

        assertThat(productWithPriceZero).isEmpty();

    }

    @Test
    public void shouldListReasultsContainsSearchedProduct() {
        categoryPage.searchItem();
        List<String> names = searchResultsPage.getNameOfSearchItem();

        String nameOfSearchingProduct = names.stream()
                .filter(name -> name.equals("Printed Summer Dress"))
                .findFirst()
                .orElse("Na liście wyników brak szukanego produktu");

        Float prices = searchResultsPage.getPriceOfSearchItem();

       Assertions.assertThat(prices).isEqualTo(28.98f);
       Assertions.assertThat(nameOfSearchingProduct).isEqualTo("Printed Summer Dress");
       Assertions.assertThat(searchResultsPage.getWhatWasTypedInFieldSearchQueryTop()).isEqualTo("\"PRINTED SUMMER DRESS\"");

    }
}
