package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement womenItems;

    @FindBy(id = "search_query_top")
    WebElement searchQueryTop;

    @FindBy(css = ".product_list.grid.row .product-name")
    WebElement nameOfSearchItem;

    @FindBy(name = "submit_search")
    WebElement submitSearch;

    public void clickOnWomenItems() {
        womenItems.click();
    }

    public void searchItem() {
        searchQueryTop.sendKeys("Printed Summer Dress");
        submitSearch.click();
    }

    public String getNameOfSearchItem() {
        return nameOfSearchItem.getText().trim();
    }
}
