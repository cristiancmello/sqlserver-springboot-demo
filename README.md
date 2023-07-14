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

* Create User

```sh
curl -X POST localhost:8080/users -d "name=John Doe"
{"message":"User(id=56, name=John Doe)"}
```

* Get User

```sh
# When exists
curl -X GET "localhost:8080/users?id=202"
{"message":"User(id=202, name=John Doe)","users":null}

# Not exists
curl -X GET "localhost:8080/users?id=204"
{"timestamp":"2023-07-14T20:34:05.160+00:00","status":404,"error":"Not Found","path":"/users"}

# All users
curl -X GET localhost:8080/users
{"message":"Total: 10","users":[{"id":56,"name":"John Doe"},{"id":102,"name":"John Doe"},...]}
```