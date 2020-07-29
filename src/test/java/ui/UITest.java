package ui;
import io.qameta.allure.Allure;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ui.utils.CreateAccTestUtils;
import ui.utils.LogInOutTestUtils;
import ui.utils.WebDriversSettings;
import utils.SoftAssert;

public class UITest extends WebDriversSettings {

    String title;

    @Test (priority = 1)
    public void logIn(){
        Allure.epic("Авторизация пользователя");
        SoftAssert softAssert = new SoftAssert();
        LogInOutTestUtils logInOut = PageFactory.initElements(driver, LogInOutTestUtils.class);
        logInOut.logIn();
        title = driver.getTitle();
        if (softAssert.assertEquals(title, "Личный кабинет", "Некорректный title"))
        {
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 2, dependsOnMethods = "logIn")
    public void logOut(){
        Allure.epic("Выход пользователя из системы");
        SoftAssert softAssert = new SoftAssert();
        LogInOutTestUtils logInOut = PageFactory.initElements(driver, LogInOutTestUtils.class);
        logInOut.logOut();
        title = driver.getTitle();
        if (softAssert.assertEquals(title, "«Кантата» — сеть галерей вкуса и интернет-магазин чая, кофе, сладостей и подарков", "Некорректный title"))
        {
            Allure.step("Открыта главная страница сайта " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 3)
    public void logInWrongEmail(){
        Allure.epic("Авторизация пользователя");
        SoftAssert softAssert = new SoftAssert();
        LogInOutTestUtils logInOut = PageFactory.initElements(driver, LogInOutTestUtils.class);
        logInOut.logInWrongEmail();
        title = driver.getTitle();
        if (softAssert.assertEquals(title, "«Кантата» — сеть галерей вкуса и интернет-магазин чая, кофе, сладостей и подарков", "Некорректный title"))
        {
            Allure.step("Открыта главная страница сайта " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 3)
    public void logInWrongPassword(){
        Allure.epic("Авторизация пользователя");
        SoftAssert softAssert = new SoftAssert();
        LogInOutTestUtils logInOut = PageFactory.initElements(driver, LogInOutTestUtils.class);
        logInOut.logInWrongPassword();
        title = driver.getTitle();
        if (softAssert.assertEquals(title, "«Кантата» — сеть галерей вкуса и интернет-магазин чая, кофе, сладостей и подарков", "Некорректный title"))
        {
            Allure.step("Открыта главная страница сайта " + title);
        }
        softAssert.checkAsserts();
    }
    
    @Test (priority = 4)
    public void createAccNoFirstName(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoFirstName();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoSurName(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoSurName();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoEmail(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoEmail();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoPassword(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoPassword();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoPhone(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoPhone();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoDay(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoDay();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoMonth(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoMonth();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoYear(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoYear();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccNoSex(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccNoSex();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccInvalidEmail(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccInvalidEmail();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccInvalidPassword(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccInvalidPassword();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccInvalidPhone(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccInvalidPhone();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccInvalidDay(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccInvalidDay();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccInvalidMonth(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccInvalidMonth();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 4)
    public void createAccInvalidYear(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.createAccInvalidYear();
        title = driver.getTitle();
        if(softAssert.assertEquals(title, "Регистрация", "Некорректный title")){
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }

    @Test (priority = 5)
    public void createAcc(){
        Allure.epic("Создание нового аккаунта");
        SoftAssert softAssert = new SoftAssert();
        CreateAccTestUtils openPage = PageFactory.initElements(driver, CreateAccTestUtils.class);
        openPage.open();
        title = driver.getTitle();
        if (softAssert.assertEquals(title, "«Кантата» — сеть галерей вкуса и интернет-магазин чая, кофе, сладостей и подарков", "Некорректный title"))
        {
            Allure.step("Открыта главная страница сайта " + title);
        }
        Allure.step("Регистрация пользователя");
        openPage.createAcc();
        title = driver.getTitle();
        if (softAssert.assertEquals(title, "Личный кабинет", "Некорректный title"))
        {
            Allure.step("Открыта страница " + title);
        }
        softAssert.checkAsserts();
    }
}
