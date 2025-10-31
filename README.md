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

## Como executar no GitHub Actions (CI)
O workflow já está configurado para:
- Executar os testes com Maven
- Gerar e fazer upload dos resultados do Allure (`target/allure-results`)
- (Opcional) Gerar o relatório HTML do Allure usando o Allure CLI

Para baixar e visualizar o relatório HTML localmente:
1. Baixe o artefato `allure-results` ou `allure-report` do job do GitHub Actions.
2. Se baixou apenas o `allure-results`, gere o relatório localmente:
   ```bash
   allure generate <pasta-do-allure-results> -o <pasta-do-relatorio>
   allure open <pasta-do-relatorio>
   ```

## O que está incluído
- Testes usando RestAssured + JUnit5
- Configuração do Allure no pom.xml para geração de relatórios
- Testes cobrindo casos de sucesso e um caso negativo para raça inexistente

## Observações
- Os testes são determinísticos, mas dependem da Dog API externa.
- Se estiver atrás de um proxy corporativo, configure as variáveis de proxy do Maven/Java.