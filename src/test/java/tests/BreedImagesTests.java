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

public class BreedImagesTests extends BaseTest {

    @Test
    @DisplayName("Deve retornar imagens para uma raça específica")
    @Description("Valida se a API retorna imagens e status 'success' para a raça 'hound'")
    void deveRetornarImagensParaRacaEspecifica() {
        buscarImagensPorRaca("hound");
    }

    @Test
    @DisplayName("Deve tratar raça inexistente de forma adequada")
    @Description("Valida se a API retorna 404 ou 200 ao buscar imagens de uma raça inexistente")
    void deveTratarRacaInexistente() {
        buscarImagensPorRacaInexistente("thisbreeddoesnotexist");
    }

    @Step("Buscar imagens para a raça: {breed}")
    void buscarImagensPorRaca(String breed) {
        Response response = given()
            .pathParam("breed", breed)
        .when()
            .get("/breed/{breed}/images");

        // Anexa o corpo da resposta ao relatório Allure
        Allure.addAttachment("Resposta da API - Raça: " + breed, "application/json", response.getBody().asPrettyString());

        response.then()
            .statusCode(200)
            .body("message", not(empty()))
            .body("status", equalTo("success"));
    }

    @Step("Buscar imagens para raça inexistente: {breed}")
    void buscarImagensPorRacaInexistente(String breed) {
        Response response = given()
            .pathParam("breed", breed)
        .when()
            .get("/breed/{breed}/images");

        // Anexa o corpo da resposta ao relatório Allure
        Allure.addAttachment("Resposta da API - Raça inexistente: " + breed, "application/json", response.getBody().asPrettyString());

        response.then()
            .statusCode(anyOf(is(404), is(200)));
    }
}