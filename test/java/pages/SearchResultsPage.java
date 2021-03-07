package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        List<WebElement> nameOfSearchItem;

        public List<String> getNameOfSearchItem() {

            return nameOfSearchItem.stream()
                    .map(el -> el.getText().trim())
                    .collect(Collectors.toList());
        }

        public Float getPriceOfSearchItem() {
            return Float.parseFloat(priceOfSearchItem.getText().substring(1, priceOfSearchItem.getText().length()));
        }

//    public List<Float> getPriceOfSearchItem() {
//        return priceOfSearchItem.stream()
//                .map(el -> Float.parseFloat(el.getText().substring(1, el.getText().length())))
//                .collect(Collectors.toList());
//    }

}
