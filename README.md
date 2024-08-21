##    

# Kamailio REST API (RPC and DB)

This repository exposes Kamailio's DB and RPC functionalities via REST APIs. Currently, it covers operations related to
the UAC module - allowing in memory management of UAC records for remote registration, stats api etcs.

## RPC exposed as REST API

Access the RPC
API  [http://127.0.0.1:6073/swagger-ui/webjars/swagger-ui/index.html#/uac-reg-rpc-controller](http://127.0.0.1:6073/swagger-ui/webjars/swagger-ui/index.html#/uac-reg-rpc-controller).

The RPC API allows you to interact with Kamailio's RPC functionalities for the UAC module. It will be further extended to all modules of kamailio

## DB API

Access the DB API
documentation [http://127.0.0.1:6073/swagger-ui/webjars/swagger-ui/index.html#/uac-reg-data-controller](http://127.0.0.1:6073/swagger-ui/webjars/swagger-ui/index.html#/uac-reg-data-controller).

The DB API allows you to interact with Kamailio's database operations for the UAC module.

## Swagger UI

![Alt text](./1.png?raw=true "Swagger UI")
![Alt text](./2.png?raw=true "Swagger UI")

## Usage

for example

- **Add API:** Use this API to add UAC records for remote registration.
- **Remove API:** Use this API to remove UAC records.
- **Info API:** Use this API to retrieve UAC records.
- **etcs....**
- **stats....**


## Prerequisites

- Need to set url for kamailio db
- make sure , JSONRPC is enabled in kamailio
- Edit application.yml (src/main/resources-default/application.yml)
    ```bash
    r2dbc:
        url: r2dbc:mysql://127.0.0.1:3306/kamailio?verifyServerCertificate=false&useSSL=true&autoReconnect=true&serverTimezone=Asia/Calcutta
        username: root
        password: Test.123!
        r2dbc:
          connection-factory:
            configuration:
              host: 127.0.0.1
              port: 3306
              user: root
              password: Test.123!
              database: kamailio
        datasource:
          driver-class-name: com.mysql.cj.jdbc.Driver
          url: jdbc:mysql://127.0.0.1:3306/kamailio
          username: root
          password: Test.123!
     
    ```

## Access

- Ensure the Kamailio server is up and running locally on `http://127.0.0.1:6073` to access these endpoints.
it can interact with multiple kamailio instances as kamailio url can be passed in API

  - For example to add UAC record in-memory
    ```bash
      curl -X 'POST' \
             'http://127.0.0.1:6073/v1/uac/rpc/add' \
              -H 'accept: */*' \
              -H 'Content-Type: application/json' \
              -d '{
                    "transactionId": "dfda12b7-ced4-11ec-9e16-0242ac1c0199",
                    "serverUrl": "http://127.0.0.1:5060",
                    "id": "1",
                    "luuid": "1234567890",
                    "l_username": "1234567890",
                    "l_domain": "172.27.0.35",
                    "r_username": "1234567890",
                    "r_domain": "172.27.0.35",
                    "realm": "org.kamailio",
                    "auth_username": "1234567890",
                    "auth_password": "a-valid-auth-token",
                    "auth_ha1": ".",
                    "auth_proxy": "sip:172.27.0.40:5070",
                    "expires": 60,
                    "flags": 0,
                    "reg_delay": 30,
                    "contact_addr": "sip:172.27.0.35:5060",
                    "socket": "172.27.0.35:5060"
            }'
    ```   

  -  To remove UAC record
    ```bash
      curl -X 'PUT' \
              'http://127.0.0.1:6073/v1/uac/rpc/remove' \
              -H 'accept: */*' \
              -H 'Content-Type: application/json' \
              -d '{
                  "transactionId": "mnda12b7-ced4-11ec-9e16-0242ac1c0199",
                  "serverUrl": "http://127.0.0.1:5060",
                  "id": "2",
                  "luuid": "1234567890"
          }'
    ```

  - DB API also can be used for crud 

    ```bash
        curl -X 'POST' \
                'http://127.0.0.1:6073/v1/uac/data' \
                -H 'accept: */*' \
                -H 'Content-Type: application/json' \
                -d '{
                    "transactionId": "mnda12b7-ced4-11ec-9e16-0242ac1c0199",
                    "lUuid": "1234567890",
                    "lUsername": "1234567890",
                    "lDomain": "172.27.0.35",
                    "rUsername": "1234567890",
                    "rDomain": "172.27.0.35",
                    "realm": "org.kamailio",
                    "authUsername": "1234567890",
                    "authPassword": "mypassword",
                    "authHa1": "",
                    "authProxy": "sip:172.27.0.40:5070",
                    "expires":60,
                    "flags": 0,
                    "regDelay": 30,
                    "contactAddr": "sip:172.27.0.35:5060",
                    "socket": "172.27.0.35:5060",
                
                }'
 
## Building JAR

To build the JAR file, use the following command:

```bash
$ ./build_jar.sh default
```

## Running with Docker

```bash
$ docker build -t kamailio-api .
$ docker run -p 6073:6073 kamailio-api
```

