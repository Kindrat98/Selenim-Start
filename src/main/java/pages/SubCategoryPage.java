package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryPage extends BasePage{

    private static final String FILTER_TEMPLATE ="//div[@data-filter-name='%s']//a/label[@for='%s']";

    private static final By CATALOG_HEADER_LOCATOR =  By.xpath("//h1[contains(@class, 'catalog-heading')]");
    private static final By GOOD_ITEM_TITLES_LOCATOR = By.xpath("//span[@class='goods-tile__title']");

    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCatalogHeaderText() {
        return driver.findElement(CATALOG_HEADER_LOCATOR).getText();
    }

    public void selectFilter(String criteria, String value) {
        driver.findElement(By.xpath(String.format(FILTER_TEMPLATE, criteria, value))).click();
    }

    public List<String> getGoodItemTitles() {
        List<String> goodItemTitles = new ArrayList<>();
        for (WebElement goodItemTitle: driver.findElements(GOOD_ITEM_TITLES_LOCATOR)) {
            goodItemTitles.add(goodItemTitle.getText());
        }
        return goodItemTitles;
    }
}
