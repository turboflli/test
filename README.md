# test
teste de avaliação

Ao baixar o projeto configure em src/main/resources/application.properties a conexão com banco

| Variavel | Valor |
| ------ | ------ |
| server.port | porta onde roda o banco |
| spring.datasource.driverClassName | classe do driver de cenexão |
| spring.datasource.url | url para conexão com banco |
| spring.datasource.username | login |
| spring.datasource.password | senha |
| spring.jpa.database-platform | Dialeto para hibernate |

Para subir o projeto rode no terminal
``
mvn spring-boot:run
``

Para acessar a aplicação  [acesse](http://localhost:8080/api)
