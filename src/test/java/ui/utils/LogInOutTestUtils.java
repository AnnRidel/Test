package ui.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class LogInOutTestUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By userButton = By.cssSelector("[data-dropdown-id=\"user\"]");
    private final By userForm = By.cssSelector("[class=\"ui-dropdown ui-dropdown--right ui-dropdown--user js-dropdown\"]");
    private final By loginForm = By.cssSelector("[class=\"ui-form ui-login ui-login--dropdown js-login-form\"]");
    private final By logout = By.cssSelector("[href=\"?logout=YES\"]");
    private final By login = By.cssSelector("[data-dropdown-id=\"login\"]");
    private final By userName = By.cssSelector("[class=\"ui-field__input js-field-input ui-field--login js-field-email\"]");
    private final By password = By.cssSelector("[class=\"ui-field__input js-field-input ui-field--password js-field-password\"]");
    private final By loginButton = By.cssSelector("[class=\"ui-button ui-button--primary ui-button--stretched ui-button--large\"]");

    public LogInOutTestUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void logOut(){
        Allure.step("Открыто окно \"Пользователь\"");
        driver.findElement(userButton).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userForm));
        Allure.step("Нажата кнопка \"Выход\"");
        driver.findElement(logout).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(login));
    }

    public void logIn(){
        Allure.step("Открыта главная страница сайта");
        driver.get("https://www.cantata.ru/");
        Allure.step("Нажата кнопка \"Войти\"");
        driver.findElement(login).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginForm));
        Allure.step("Введен email пользователя \"qwerty4309@mail.ru\"");
        driver.findElement(userName).sendKeys("qwerty4309@mail.ru");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Нажата кнопка \"Войти в личный кабинет\"");
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"ui-account__heading\"]")));
    }

    public void logInWrongEmail(){
        Allure.step("Открыта главная страница сайта");
        driver.get("https://www.cantata.ru/");
        Allure.step("Нажата кнопка \"Войти\"");
        driver.findElement(login).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginForm));
        Allure.step("Введен email пользователя \"111@mail.ru\"");
        driver.findElement(userName).sendKeys("111@mail.ru");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Нажата кнопка \"Войти в личный кабинет\"");
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"ui-form__message js-form-message ui-form__message--state_visible\"]")));
    }

    public void logInWrongPassword(){
        Allure.step("Открыта главная страница сайта");
        driver.get("https://www.cantata.ru/");
        Allure.step("Нажата кнопка \"Войти\"");
        driver.findElement(login).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginForm));
        Allure.step("Введен email пользователя \"qwerty4309@mail.ru\"");
        driver.findElement(userName).sendKeys("qwerty4309@mail.ru");
        Allure.step("Введен пароль пользователя \"111111\"");
        driver.findElement(password).sendKeys("111111");
        Allure.step("Нажата кнопка \"Войти в личный кабинет\"");
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"ui-form__message js-form-message ui-form__message--state_visible\"]")));
    }
}
