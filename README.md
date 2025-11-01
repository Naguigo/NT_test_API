# Testes Automatizados da Dog API (Java + RestAssured)

## Visão Geral
Suite de testes automatizados para a Dog API ([documentação](https://dog.ceo/dog-api/documentation)).  
Inclui testes funcionais para os endpoints:
- GET /breeds/list/all
- GET /breed/{breed}/images
- GET /breeds/image/random

## Requisitos
- Java 17+
- Maven
- (Opcional) Allure CLI para visualizar relatórios: https://docs.qameta.io/allure/

## Como executar localmente
```bash
cd dog-api-tests
mvn clean test
# gerar e servir o relatório Allure (opcional)
mvn allure:serve
```

## Como visualizar o relatório no GitHub Actions (CI)
O workflow já está configurado para:
- Executar os testes com Maven
- Gerar e fazer upload dos resultados do Allure (`target/allure-results`)
- Gerar o relatório HTML do Allure (`target/site/allure-maven-plugin`)
- Publicar automaticamente o relatório Allure no GitHub Pages

### Acessando o relatório Allure publicado
Após um push ou pull request na branch `main`, o relatório Allure será publicado automaticamente no GitHub Pages do repositório.

**Acesse o relatório em:**  https://naguigo.github.io/NT_test_API/