package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
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

        for (String str : names) {
            System.out.println(str);
        }
        Float prices = searchResultsPage.getPriceOfSearchItem();

        System.out.println(prices);

//        for (Float price : prices) {
//            System.out.println(price);
//        }


       // Assertions.assertThat(searchResultsPage.getPriceOfSearchItem().floatValue())
       // Assertions.assertThat(searchResultsPage.getPriceOfSearchItem().compareTo((float) 26.00));
    }
}
