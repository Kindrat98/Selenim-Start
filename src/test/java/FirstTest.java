import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest extends BaseTest {

    @Test
    public void t1() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        sleep(2000);
        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
        searchInput.clear();
        searchInput.sendKeys("String", Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.ENTER);
        sleep(2000);
    }

    @Test
    public void t2() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        sleep(2000);
        WebElement talkLink = driver.findElement(By.xpath("//li[@id='ca-talk']/a"));
        System.out.println(talkLink.getText());
        System.out.println(talkLink.isDisplayed());
        System.out.println(talkLink.isEnabled());
        System.out.println(talkLink.isSelected());
        talkLink.click();
        sleep(2000);
    }


    @Test
    public void facebook() {
        String url = "https://www.facebook.com/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        sleep(5000);
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='email']"));
        WebElement passInput = driver.findElement(By.xpath("//*[@id='pass']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@name='login']"));
//        emailInput.sendKeys("q@com.ua");
//        passInput.sendKeys("qwerty");
        submitButton.submit();
//        sleep(20000);
        WebElement validationMessage = driver.findElement(By.xpath("//*[@id='email_container']/div[last()]"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationMessage));
        System.out.println(validationMessage.getText());
//        webDriverWait.until(ExpectedConditions.textToBePresentInElement(validationMessage , "error"));
    }


}
