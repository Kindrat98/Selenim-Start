import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainCategoryPage;
import pages.SubCategoryPage;

import java.util.List;

public class RozetkaTest extends BaseTest{

    public static final String ROZETKA_URL = "https://rozetka.com.ua";
    public static final String COMPUTERS_ENDPOINT = "/computers-notebooks/c80253";
    public static final String LAPTOPS_ENDPOINT = "notebooks/c80004";

    public static final String UA_LANG = "/ua";

    public static final String COMPUTERS_URL = ROZETKA_URL + UA_LANG + COMPUTERS_ENDPOINT;
    public static final String LAPTOPS_URL = ROZETKA_URL + UA_LANG + LAPTOPS_ENDPOINT;

    public static final String PRODUCER_CRITERIA = "producer";
    public static final String APPLE_COMPANY = "Apple";

    @Test
    public void computersSearch() {
        driver.get(COMPUTERS_URL);
        String mainCategoryItem = "Ноутбуки";
        MainCategoryPage mainCategoryPage = new MainCategoryPage(driver);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);

        mainCategoryPage.chooseItem(mainCategoryItem);
        String actualCatalogHeader = subCategoryPage.getCatalogHeaderText();

        Assert.assertEquals(actualCatalogHeader, mainCategoryItem);
    }

    @Test
    public void brandChoose() {
        driver.get(LAPTOPS_URL);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);

        subCategoryPage.selectFilter(PRODUCER_CRITERIA, APPLE_COMPANY);
        List<String> goodItemTitles = subCategoryPage.getGoodItemTitles();

        for (String goodItemTitle: goodItemTitles) {
            Assert.assertTrue(goodItemTitle.contains(APPLE_COMPANY));
        }
    }

    @Test
    public void chooseGood() {
        driver.get(LAPTOPS_URL);
//        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement appleCompany = driver.findElement(By.xpath("//div[@data-filter-name='producer']//a/label[@for='Apple']"));
        appleCompany.click();
        WebElement goodItemFirst = driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
        String expectedResult = goodItemFirst.getText();
        goodItemFirst.click();
        sleep(1000);
        WebElement productHeader = driver.findElement(By.xpath("//h1[@class='product__title']"));
        String actualResult = productHeader.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
