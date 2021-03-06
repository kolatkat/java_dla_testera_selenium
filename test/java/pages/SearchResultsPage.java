package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

import java.util.List;
import java.util.stream.Collectors;


    public class SearchResultsPage extends BasePage {
        public SearchResultsPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = ".product_list.grid.row .right-block .price.product-price")
        WebElement priceOfSearchItem;

        @FindBy(css = ".product_list.grid.row .right-block .product-name")
        List<WebElement> namesOfSearchItem;

        @FindBy(id = "uniform-selectProductSort")
        WebElement uniformSelectProductSort;

        @FindBy(xpath = "//*[@id='center_column']/h1/span[1]")
        WebElement searchItem;

        public Float getPriceOfSearchItem() {
            return Float.parseFloat(priceOfSearchItem.getText().substring(1, priceOfSearchItem.getText().length()));
        }

        public List<String> getNameOfSearchItem() {
            wait.until(ExpectedConditions.visibilityOf(uniformSelectProductSort));

            return namesOfSearchItem.stream()
                    .map(el -> el.getText().trim())
                    .collect(Collectors.toList());
        }

        public String getWhatWasTypedInFieldSearchQueryTop() {
                return searchItem.getText();
        }

//    public List<Float> getPriceOfSearchItem() {
//        return priceOfSearchItem.stream()
//                .map(el -> Float.parseFloat(el.getText().substring(1, el.getText().length())))
//                .collect(Collectors.toList());
//    }

}
