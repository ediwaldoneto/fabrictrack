

# Sistema de Vendas

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/seu-usuario/nome-do-repositorio/blob/main/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/seu-usuario/nome-do-repositorio)](https://github.com/seu-usuario/nome-do-repositorio/stargazers)

Este é um sistema de vendas, desenvolvido utilizando Spring Boot e MySQL. O sistema permite gerenciar o estoque, realizar vendas, registrar transações financeiras e gerar relatórios.

## Status de Desenvolvimento

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Tecnologias utilizadas

- Java 11
- Spring Boot 2.7.12
- MySQL

## Configuração do banco de dados

- Crie um banco de dados MySQL com o nome `fabric`.
- Execute o script de criação do banco de dados localizado em `src/main/resources/db` arquivo  `fabric.sql` para criar as tabelas necessárias.

## Configuração do projeto

- Clone o repositório para o seu ambiente local.
- Importe o projeto em sua IDE preferida como um projeto Maven.

## Configuração do arquivo application.yml

No arquivo `application.yml`, localizado em `src/main/resources`, você precisa configurar as informações de conexão com o banco de dados:

```yaml
spring:
    application:
       name: fabric
    profiles:
       active: local,default
datasource:
    url: jdbc:mysql://localhost:3306/fabric
    driver_class_name: com.mysql.cj.jdbc.Driver
    pool_name: fabric
    connection_timeout: 60000
    max_pool_size: 3
datasource_username: 'seu_username'
datasource_password: 'seu_password'

 
 ```
  - Certifique-se de substituir seu_usuario pelo seu nome de usuário do MySQL e sua_senha pela sua senha do MySQL.

## Executando o projeto
Após configurar corretamente o projeto, você pode executá-lo usando sua IDE ou pelo terminal. Para executar o projeto pelo terminal, navegue até o diretório raiz do projeto e execute o seguinte comando:

```
mvn spring-boot:run
```

