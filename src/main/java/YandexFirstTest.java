import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Sergey
 */
public class YandexFirstTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "https://yandex.ru/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void yandexTest() {
        driver.findElement(By.xpath("//*[@data-id='market']")).click();
        driver.findElement(By.xpath("//*[@class='link topmenu__link']/../*[contains(text(),'Электроника')]")).click();
        driver.findElement(By.xpath("//*[contains(@class,'catalog-menu__list')]/..//*[text()='Телевизоры']")).click();
        driver.findElement(By.xpath("//*[@class='_1z9VjXlbXw']")).click();
        fillField(By.id("glf-pricefrom-var"), 20000);
        driver.findElement(By.xpath("//*[@class='checkbox__box']/..//*[contains(text(),'Samsung')]")).click();
        driver.findElement(By.xpath("//*[@class='checkbox__box']/..//*[contains(text(),'LG')]")).click();
        driver.findElement(By.xpath("//*[contains(@class,'i-bem button_action_show-filtere')]")).click();
      //  driver.findElement(By.xpath("//div[contains(@class,'n-snippet-card2_js_inited')][1]//.//a[contains(@class,'link n-link_theme_blue link_type_cpc i')]")).click();
        fillFieldString(By.xpath("//*[contains(@class,'suggest2-autocomplete-shadow')]"), getText(By.xpath("//div[contains(@class,'n-snippet-card2_js_inited')][1]//.//a[contains(@class,'link n-link_theme_blue link_type_cpc i')]")));
        driver.findElement(By.xpath("//*[@class='button2__text']/..//span[contains(text(),'Найти')]")).click();
    }

    public void fillField(By locator, int value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys();
    }

    public void fillFieldString(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys();
    }


    public String getText(By locator) {
        String text;
        text = driver.findElement(locator).getText();
        return text;

    }

    @After
    public void afterTest() {


    }


}





