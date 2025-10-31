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

public class BreedListTests extends BaseTest {

    @Test
    @DisplayName("Deve retornar a lista de todas as raças")
    @Description("Valida se a API retorna status 200 e uma lista de raças no campo 'message', além do status 'success'")
    void deveRetornarListaDeTodasAsRacas() {
        validarListaDeRacas();
    }

    @Step("Consultar endpoint de listagem de raças")
    void validarListaDeRacas() {
        Response response = given()
            .when()
                .get("/breeds/list/all");

        // Anexa o corpo da resposta como evidência no Allure
        Allure.addAttachment("Resposta da API", "application/json", response.getBody().asPrettyString());

        response.then()
            .statusCode(200)
            .body("message", notNullValue())
            .body("status", equalTo("success"));
    }
}