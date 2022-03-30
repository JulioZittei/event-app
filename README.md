<h1 align="center">Event App</h1>

<p align="center">
  <a href="#-technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-how-to-run">How to run</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-license">License</a>
</p>

<p align="center">
  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=8257E5&labelColor=000000">
</p>

<p align="center">
  <img alt="app" src=".github/event-app.gif" width="100%">
</p>

## ✨ Technologies

This project was developed with the following technologies:

- [SpringBoot](https://spring.io/projects/spring-boot)
- [Spring Framework](https://spring.io/projects/spring-framework)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)
- [Materialize CSS](https://materializecss.com)
- [PostgreSQL](https://www.postgresql.org/)

## 🚀 How to run

- Clone the repository;
- Import this project to your IDE
- Configure the database connection in the file `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/eventapp?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username={USER_NAME}
spring.datasource.password={USER_PASSWORD}

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
```

- Start the server with `Run as Java Application`

The application can be accessed at [`localhost:8080`](http://localhost:8080)

You can access the live web application [`clicking here`](https://event-app-online.herokuapp.com/eventos).

<p align="center">
  <img alt="app" src=".github/qr-code.jpg" width="20%">
</p>

## 📄 License

This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.

---

Made with ♥ by Julio Zittei 👋🏻
