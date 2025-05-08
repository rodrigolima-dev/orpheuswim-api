# 🧶 Orpheuswim - Backend

API REST desenvolvida em **Java com Spring Boot** para gerenciar produtos de uma loja de crochê. Este projeto tem como objetivo oferecer uma base sólida para o controle de produtos e categorias, com persistência de dados em banco MySQL.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven
- Springdoc OpenAPI (Swagger)
- Spring Security (autenticação com Bearer Token)

## 📦 Funcionalidades da API

- ✅ Cadastro de produtos
- ✅ Listagem de produtos
- ✅ Atualização e exclusão de produtos
- ✅ Gerenciamento de categorias de produtos
- ✅ Autenticação com Token JWT (em rotas protegidas)

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

## 🔐 Autenticação

Algumas rotas estão protegidas e requerem autenticação via **Bearer Token (JWT)**. Para acessá-las:

1. Faça login (ou cadastro) usando o endpoint de autenticação.
2. Receba o token JWT.
3. Envie o token no cabeçalho `Authorization` das requisições protegidas.

Exemplo:

```
Authorization: Bearer seu_token_aqui
```

## 📚 Documentação com Swagger

A documentação interativa da API é gerada automaticamente com o Springdoc OpenAPI.

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Documentação JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 🔗 Principais Endpoints da API

### 📦 Produtos Públicos

| Método | Rota            | Descrição                                              | Autenticação |
|--------|------------------|----------------------------------------------------------|--------------|
| GET    | `/api/products` | Lista todos os produtos (filtro por categoria e busca opcional) | ❌ Não       |
| GET    | `/api/releases` | Lista os produtos mais recentes (limite por query param) | ❌ Não       |

---

### 🔐 Rotas de Administração (Requer Token Bearer)

| Método | Rota              | Descrição                             | Autenticação |
|--------|-------------------|-----------------------------------------|--------------|
| POST   | `/api/admin`      | Cadastra um novo produto                | ✅ Sim        |
| PUT    | `/api/admin`      | Atualiza um produto existente           | ✅ Sim        |
| DELETE | `/api/admin/{id}` | Exclui um produto pelo ID               | ✅ Sim        |
| GET    | `/api/admin/{id}` | Detalha um produto específico pelo ID   | ✅ Sim        |

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

## 📌 Status do Projeto

🚧 Em desenvolvimento — novas funcionalidades sendo implementadas.

## 📄 Licença

Este projeto está sob a licença MIT.
