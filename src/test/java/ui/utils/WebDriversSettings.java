package ui.utils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WebDriversSettings {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void prepare() {
        //Требуется хром версии 84
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        Allure.step("Запущен драйвер chromedriver");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void after() {
    Allure.step("Закрытие браузера");
        driver.quit();
    }
}
