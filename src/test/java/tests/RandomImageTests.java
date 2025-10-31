package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RandomImageTests extends BaseTest {

    @Test
    @DisplayName("Deve retornar uma imagem aleatória de cachorro")
    @Description("Valida se a API retorna status 200, o campo 'message' com uma URL e o status 'success'")
    void deveRetornarImagemAleatoria() {
        validarImagemAleatoria();
    }

    @Step("Consultar endpoint de imagem aleatória")
    void validarImagemAleatoria() {
        Response response = given()
            .when()
            .get("/breeds/image/random");

        // Anexa o corpo da resposta como evidência no Allure
        Allure.addAttachment("Resposta da API", "application/json", response.getBody().asPrettyString());

        response.then()
            .statusCode(200)
            .body("message", containsString("https://"))
            .body("status", equalTo("success"));
    }
}