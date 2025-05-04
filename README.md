# 🧶 Orpheuswim - Backend

API REST desenvolvida em **Java com Spring Boot** para gerenciar produtos de uma loja de crochê. Este projeto tem como objetivo oferecer uma base sólida para o controle de produtos e categorias, com persistência de dados em banco MySQL.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven
- Swagger/OpenAPI (para documentação da API)

## 📦 Funcionalidades da API

- ✅ Cadastro de produtos
- ✅ Listagem de produtos
- ✅ Atualização e exclusão de produtos
- ✅ Gerenciamento de categorias de produtos

## 🛠️ Como rodar o projeto

### Pré-requisitos

- Java 17+ instalado
- MySQL em execução
- Maven instalado

### Passos para rodar

```bash
# Clone o repositório
git clone https://github.com/rodrigolima-dev/orpheuswim-api

# Acesse a pasta do projeto
cd orpheuswim-api

# Configure o banco de dados em src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/loja_croche
spring.datasource.username=root
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update

# Rode a aplicação
./mvnw spring-boot:run
```

### Swagger

Após iniciar o projeto, acesse a documentação da API em:

```
http://localhost:8080/swagger-ui.html
```

## 🗃️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/orpheuswim/api/
│   │   ├── controllers/
│   │   ├── domain/
│   │   ├── infra/
│   │   └── ApiApplication.java
│   └── resources/
│       ├── application.properties
│       └── db
```

## ✅ Testes

Você pode rodar os testes com o seguinte comando:

```bash
./mvnw test
```

## 📄 Licença

Este projeto está sob a licença MIT.