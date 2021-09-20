package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainCategoryPage extends BasePage{

    private static final String ITEM_TEMPLATE = "//a[@title='%s']/parent::div";

    public MainCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void chooseItem(String item) {
        sleep(500);
        driver.findElement(By.xpath(String.format(ITEM_TEMPLATE, item))).click();
    }


}
