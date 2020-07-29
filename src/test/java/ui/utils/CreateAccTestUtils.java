package ui.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CreateAccTestUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By createAcc = By.cssSelector("[class=\"ui-header__link js-modal\"]");
    private final By form = By.cssSelector("[class=\"ui-form js-auth-form\"]");
    private final By firstName = By.cssSelector("[class=\"ui-field__input js-field-input js-field-name\"]");
    private final By surName = By.cssSelector("[class=\"ui-field__input js-field-input\"]");
    private final By eMail = By.cssSelector("[class=\"ui-field__input js-field-input js-field-email\"]");
    private final By password = By.cssSelector("[name=\"REGISTER[PASSWORD]\"]");
    private final By phone = By.cssSelector("[class=\"ui-field__input js-field-input js-field-phone\"]");
    private final By day = By.cssSelector("[class=\"ui-field__input js-field-input js-field-mask-day\"]");
    private final By month = By.cssSelector("[class=\"ui-field__input js-field-input js-field-mask-month\"]");
    private final By year = By.cssSelector("[class=\"ui-field__input js-field-input js-field-mask-year\"]");
    private final By sex = By.cssSelector("[for=\"gender-male\"]");
    private final By createAccButton = By.xpath("//button/span[text()=\"Зарегистрироваться\"]");

    public CreateAccTestUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void open(){
        driver.get("https://www.cantata.ru/");
    }

    public static String getRandomPhone() {
        String s = "123456789";
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append(9);
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return phoneNumber.toString();
    }

    public static String getRandomEmail() {
        int n = new Random().nextInt(10000);
        return ("qwerty" + n + "@mail.ru");
    }

    public void createAcc(){
        driver.findElement(createAcc).click();
        Allure.step("Нажата кнопка регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"ui-account__heading\"]")));
    }

    public void createAccNoFirstName(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Введите имя\"]")));
    }

    public void createAccNoSurName(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Введите фамилию\"]")));
    }

    public void createAccNoEmail(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Введите email\"]/../div[@class=\"ui-field ui-field--placeholder-mobile ui-field--type-email js-field\"]")));
    }

    public void createAccNoPassword(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Введите пароль\"]/../div/input[@name=\"REGISTER[PASSWORD]\"]")));
    }

    public void createAccNoPhone(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Введите телефон\"]")));
    }

    public void createAccNoDay(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"ui-field ui-field--type-text js-field ui-field--state_error\"]/input[@class=\"ui-field__input js-field-input js-field-mask-day\"]")));
    }

    public void createAccNoMonth(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"ui-field ui-field--type-text js-field ui-field--state_error\"]/input[@class=\"ui-field__input js-field-input js-field-mask-month\"]")));
    }

    public void createAccNoYear(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"ui-field ui-field--type-text js-field ui-field--state_error\"]/input[@class=\"ui-field__input js-field-input js-field-mask-year\"]")));
    }

    public void createAccNoSex(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Укажите пол\"]")));
    }

    public void createAccInvalidEmail(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        driver.findElement(eMail).sendKeys("1");
        Allure.step("Введен email пользователя \"" + "1" + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Указан некорректный email\"]/../div[@class=\"ui-field ui-field--placeholder-mobile ui-field--type-email js-field\"]")));
    }

    public void createAccInvalidPassword(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("1");
        Allure.step("Введен пароль пользователя \"1\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Минимальное кол-во символов - 6\"]/../div/input[@name=\"REGISTER[PASSWORD]\"]")));
    }

    public void createAccInvalidPhone(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys("1");
        Allure.step("Введен телефон пользователя \"" + "1" + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()=\"Неверный формат номера\"]")));
    }

    public void createAccInvalidDay(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("33");
        Allure.step("Введен день рождения пользователя \"33\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"ui-field ui-field--type-text js-field ui-field--state_error\"]/input[@class=\"ui-field__input js-field-input js-field-mask-day\"]")));
    }

    public void createAccInvalidMonth(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("33");
        Allure.step("Введен месяц рождения пользователя \"33\"");
        driver.findElement(year).sendKeys("1980");
        Allure.step("Введен год рождения пользователя \"1980\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"ui-field ui-field--type-text js-field ui-field--state_error\"]/input[@class=\"ui-field__input js-field-input js-field-mask-month\"]")));
    }

    public void createAccInvalidYear(){
        driver.get("https://www.cantata.ru/register/");
        Allure.step("Открыта страница регистрации пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(form));
        driver.findElement(firstName).sendKeys("Ivan");
        Allure.step("Введено имя пользователя \"Ivan\"");
        driver.findElement(surName).sendKeys("Ivanov");
        Allure.step("Введена фамилия пользователя \"Ivanov\"");
        String randomEmail = getRandomEmail();
        driver.findElement(eMail).sendKeys(randomEmail);
        Allure.step("Введен email пользователя \"" + randomEmail + "\"");
        driver.findElement(password).sendKeys("Qwerty123");
        Allure.step("Введен пароль пользователя \"Qwerty123\"");
        String randomPhone = getRandomPhone();
        driver.findElement(phone).sendKeys(randomPhone);
        Allure.step("Введен телефон пользователя \"" + randomPhone + "\"");
        driver.findElement(day).sendKeys("01");
        Allure.step("Введен день рождения пользователя \"01\"");
        driver.findElement(month).sendKeys("03");
        Allure.step("Введен месяц рождения пользователя \"03\"");
        driver.findElement(year).sendKeys("3333");
        Allure.step("Введен год рождения пользователя \"3333\"");
        driver.findElement(sex).click();
        Allure.step("Выбран пол пользователя \"мужской\"");
        driver.findElement(createAccButton).click();
        Allure.step("Нажата кнопка создания аккаунта пользователя");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"ui-field ui-field--type-text js-field ui-field--state_error\"]/input[@class=\"ui-field__input js-field-input js-field-mask-year\"]")));
    }
}
