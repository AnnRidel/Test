package api;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class APITest {

    @Test (priority = 1)
    public void postNewPet(){
        String id = "101011";
        Allure.epic("Добавление данных");
        Allure.step("Отправка запроса POST на добавление данных о питомце");
        given().contentType("application/json").body("{ \"id\": " + id + ", \"category\": { \"id\": 1, \"name\": \"dog\" }, \"name\": \"doggie\", \"photoUrls\": [ \"none\" ], \"tags\": [ { \"id\": 0, \"name\": \"Bob\" } ], \"status\": \"available\" }").
        when().post("https://petstore.swagger.io/v2/pet").
                then().statusCode(200);
        Allure.step("Добавлены данные о питомце");
    }

    @Test (priority = 2)
    public void getPetById(){
        Allure.epic("Получение данных по ID");
        String id = "101011";
        Allure.step("Отправка запроса GET на получение данных о питомце с ID " + id);
        when().get("https://petstore.swagger.io/v2/pet/"+ id).
                then().statusCode(200).assertThat().body("name", equalTo("doggie"), "status", equalTo("available"));
        Response response=get("https://petstore.swagger.io/v2/pet/"+ id);
        Allure.step("Получены данные о питомце с ID " + id + " :" + response.getBody().asString());
    }

    @Test (priority = 3)
    public void updateExistingPet(){
        Allure.epic("Изменение данных");
        Allure.step("Отправка запроса PUT на изменение данных о питомце");
        String id = "101011";
        given().contentType("application/json").body("{ \"id\": " + id + ", \"category\": { \"id\": 1, \"name\": \"dog\" }, \"name\": \"doggie\", \"photoUrls\": [ \"none\" ], \"tags\": [ { \"id\": 0, \"name\": \"Bob\" } ], \"status\": \"unavailable\" }").
                when().put("https://petstore.swagger.io/v2/pet").
                then().statusCode(200);
        Allure.step("Изменены данные о питомце");
        when().get("https://petstore.swagger.io/v2/pet/"+ id).
                then().statusCode(200).assertThat().body("name", equalTo("doggie"), "status", equalTo("unavailable"));
        Response response=get("https://petstore.swagger.io/v2/pet/"+ id);
        Allure.step("Успешно изменены данные о питомце с ID " + id + " :" + response.getBody().asString());
    }

    @Test (priority = 4)
    public void deletePetById(){
        Allure.epic("Удаление данных по ID");
        String id = "101011";
        Allure.step("Отправка запроса DELETE на удаление данных о питомце с ID " + id);
        when().delete("https://petstore.swagger.io/v2/pet/"+ id).
                then().statusCode(200).assertThat().body("type", equalTo("unknown"));
       Allure.step("Удалены данные о питомце с ID " + id);
    }
}
