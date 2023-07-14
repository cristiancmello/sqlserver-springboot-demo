#!/usr/bin/env bash

docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=aabe3ijdvWk_3&3pqLzxlM" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2022-latest
