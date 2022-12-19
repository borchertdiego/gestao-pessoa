# API para gestão de pessoas

## Descrição do projeto

Projeto feito utilizando Java 17 com o framework Spring Boot 3.0 e as seguintes dependências:

- Spring Web
- Spring Data JPA
- Lombok
- Flyway Migration
- Validation
- MySQL Driver
- Swagger 2.0

## Requisitos para rodar o projeto

- É necessário criar um usuário root/root em um banco de dados MySql e um database chamado gestao_pessoa.
    > Como o projeto utiliza o Flyway Migration, na primeira vez que rodar o projeto a tabela pessoas será criada automaticamente.
  
## Observações

- No lugar de classes normais para o DTO foram utilizados Record (inserido no Java 14).
- É possível testar a API pelo Swagger no [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html) após subir o projeto local.
- A validação dos campos de entrada da API são feitas pelo Bean Validation através de anotações.



