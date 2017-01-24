# oracle-db-connection

https://twitter.com/masanobuimai/status/823831027353169920

## 前提条件

* WildFly 10.1.0.Final
* JDK 8
* Oracle Database Enterprise Edition 12.1.0.2.0

## ojdbc7.jar を静的モジュールとしてインストール

あらかじめ Oracle JDBC Driver(ojdbc7.jar) を適当なパスに置いておく。

> ここでは `/tmp` 以下に置いたとします

``` sh
cd ${WILDFLY_HOME}
bin/jboss-cli.sh --file=/this/project/clis/add-ojdbc7-as-module.cli
```

`${WILDFLY_HOME}/modules` 以下に module.xml と ojdbc7.jar が配置される。 

``` sh
$ tree modules/com/oracle
modules/com/oracle
└── main
    ├── module.xml
    └── ojdbc7.jar
```

## データソースの設定

``` sh
cd ${WILDFLY_HOME}
bin/jboss-cli.sh --file=/this/project/clis/add-datasource.cli
```

## WildFly の起動

``` sh
cd ${WILDFLY_HOME}
bin/standalone.sh
```

## アプリケーションのデプロイ

``` sh
./mvnw clean wildfly:deploy
```

## API へのアクセス

``` sh
curl localhost:8080/oracle-db-connection -s | jq .
```

以下のようなレスポンスが得られる。

``` json
{
  "databaseProductName": "Oracle",
  "databaseMajorVersion": 12,
  "driverVersion": "12.1.0.2.0"
}
```
