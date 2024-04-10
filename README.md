# kafka-quarkus

Este proyecto consta de dos aplicaciones hechas en Quarkus y se basa en el siguiente [getting started](https://quarkus.io/guides/kafka-getting-started)

Para aprender más es recomendable la siguiente lectura [kafka-quarkus-guide](https://es.quarkus.io/guides/kafka).

Cuenta tambien con un [ejemplo](https://github.com/quarkusio/quarkus-quickstarts/tree/main/kafka-quickstart) de quarkus oficial

## Pre-requisitos

- JDK 17+
- Maven configurado y actualizado
- Docker en ejecucion

## Ejecucion de cada aplicacion en modo dev

Cada aplicacion cuenta con su propio Readme.Se pueden abrar en dos terminales, cada una ubicada en la carpeta del proyecto y ejecutar
```shell script
mvn compile quarkus:dev
```