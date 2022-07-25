# IBAN
## Coding Challenge

## 💬 What's in this document
* [Technologies used in this project](https://github.com/guplima1986/iban_challenge#technologies-used-in-this-project)
* [Running the project with Docker](https://github.com/guplima1986/iban_challenge#running-the-project-with-docker)
* [Endpoints available](https://github.com/guplima1986/iban_challenge#endpoints-available)

## Technologies used
|          Tecnologies        |         Link            |
|:---------------------------:|:-----------------------:|
|          Springboot         | [https://spring.io/projects/spring-boot] |
|          Rabbit             | [https://www.rabbitmq.com/] |
|          Docker             | [https://www.docker.com/] |
|          MySQL              | [https://www.mysql.com/] |

## 🐳 Executando o projeto com Docker

* Requisito: [Docker](https://docs.docker.com/get-docker/)

Run Docker, open the terminal '.../iban_challenge' and execute the command:

```sh
docker-compose up
```

## 🔥 Endpoints available
After running the project you will have the application running in **http://localhost:8080/<endpoint>**

|           endpoint          	|                                 function                                 	|
|:---------------------------:	|:----------------------------------------------------------------------:	|
|            /subscription  	|           To create a subscription in the informed campaign              	|
