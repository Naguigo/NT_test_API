## 🐶 Testes Automatizados da Dog API (Java + RestAssured)
### 🔹 Visão Geral

Suite de testes automatizados para a Dog API, cobrindo os seguintes endpoints:
GET /breeds/list/all
GET /breed/{breed}/images
GET /breeds/image/random
Inclui testes funcionais que validam sucesso e falha (ex.: raça inexistente).

### ⚙️ Requisitos
Java 17+
Maven
(Opcional) Allure CLI para visualização de relatórios



### 🧪 Como executar localmente
1️⃣ Clonar o repositório
git clone https://github.com/Naguigo/NT_test_API.git
cd NT_test_API


2️⃣ Executar os testes
mvn clean test

3️⃣ Gerar e visualizar relatório Allure (opcional)
Usando o plugin Maven:
mvn allure:serve


Usando o Allure CLI diretamente:
allure generate target/allure-results -o target/allure-report --clean
allure open target/allure-report


### 🌐 Visualizando o relatório no GitHub Actions (CI/CD)

O workflow do GitHub Actions realiza automaticamente:

1. Execução dos testes com Maven
2. Geração e upload dos resultados Allure (target/allure-results)
3. Geração do relatório HTML do Allure (target/site/allure-maven-plugin)
4. Publicação automática do relatório no GitHub Pages

Acessando o relatório publicado:
https://naguigo.github.io/NT_test_API/



### ✅ O que está incluído

Testes usando RestAssured + JUnit5

Configuração do Allure no pom.xml para geração de relatórios

Testes cobrindo casos de sucesso e caso negativo para raça inexistente

⚠️ Observações

Os testes são determinísticos, mas dependem da Dog API externa.

Se estiver atrás de um proxy corporativo, configure as variáveis de proxy do Maven/Java conforme necessário.

Para ajustes ou exemplos de blocos de código dos testes, basta solicitar.