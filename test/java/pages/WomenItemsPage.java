package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WomenItemsPage extends BasePage {

    public WomenItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".right-block .price.product-price")
    List<WebElement> womenProductNames;

    public List<Float> getPrices() {
        return  womenProductNames.stream()
                .map(elem -> Float.parseFloat(elem.getText().substring(1, elem.getText().length())))
                .collect(Collectors.toList());
    }
}
