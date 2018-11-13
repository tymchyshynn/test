package ua.org.autotest;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class FirstTest {


    private static WebDriver driverChrome;
   // private static WebDriver driverMozilla;

   public static SelenideElement
        //searchField = $(By.id("lst-ib"));
        entryLink = $(By.xpath("//div[contains(text(), 'Увійти')]")) ,
        nameField = $(By.name("username")),
        passwordField = $(By.name("password")),
        submitButtom = $(By.id("admin_submit"));



    @BeforeClass
    public static void setupChrome() {
        System.setProperty("Webdriver.chrome.driver", "/Users/vasyltymchyshyn/IdeaProjects/mytest/chromedriver");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driverChrome = new ChromeDriver(options);
        //driver.get("https://www.google.com.ua");

    }

    //@BeforeClass
   // public static void setupMozilla() {
       // System.setProperty("Webdriver.gecko.driver", "/Users/vasyltymchyshyn/IdeaProjects/mytest/geckodriver");
       // driverMozilla = new FirefoxDriver();
       // WebDriverRunner.setWebDriver(driverMozilla);

   /// }




    @Test
    public void useLogin() {

        WebDriverRunner.setWebDriver(driverChrome);

        open("https://kinobox.in.ua/");
        //driverChrome.switchTo().alert().dismiss();
        //searchField.sendKeys("Wikipedia");
       // searchField.submit();
        entryLink.click();
        //nameField.sendKeys("tymchyshynn@gmail.com");
        nameField.setValue("tymchyshynn@gmail.com");
        passwordField.sendKeys("1645av");
        submitButtom.click();
        System.out.println("Page title is: " + driverChrome.getTitle());
       // System.out.println("Page title is: " + driverMozilla.getTitle());


    }

    @AfterClass
    public static void tearDownChrome() {
        driverChrome.quit();
    }

   // @AfterClass
    //public static void tearDownMozilla() {
        //driverMozilla.quit();
   // }

}
