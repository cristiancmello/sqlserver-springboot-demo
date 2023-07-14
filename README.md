# SQL Server + JPA + Spring Boot Demo

* Maven 3
* Spring Boot 3
* MS SQL Server 2022

## Build

```sh
mvn clean install
```

* Please run MS SQL Server container before 

```sh
./sqlserver.docker.run.sh
```

> Obs.: MSSQL_SA_PASSWORD is aabe3ijdvWk_3&3pqLzxlM and DB is 'sa'

## Running

```sh
mvn spring-boot:run
```

## Testing

```sh
curl -X POST localhost:8080/users -d "name=John Doe"
{"message":"User(id=56, name=John Doe)"}
```