# Transactions-Api

## About

This project is made to simulate a bank account, you can create an accout with a document number, fetch the created account
 and create transactions for your account.

## Data structure

The data structure for the project contains three tables:

### Accounts

The account contain a account id and a document number for its owner.

| Account_ID | Document_Number
|------------|----------------
| 1          | 12345678900    

### Operation Types

There are currently four operation types, as follows:


|OperationType_ID | Description
|------------|----------------
|1 | COMPRA A VISTA
|2 | COMPRA PARCELADA
|3 | SAQUE
|4 | PAGAMENTO

### Transactions

And last but not least, the transactions table, which contains dependencies with the account table, and the operation type table.

Also, it contains the value for the transaction and its date.


|Transaction_ID | Account_ID | OperationType_ID | Amount | EventDate
|------------|----------------|-----------------|--------|----------
|1 | 1 | 1 | -50.0 | 2020-01-01T10:32:07.7199222
|2 | 1 | 1 | -23.5 | 2020-01-01T10:48:12.2135875
|3 | 1 | 1 | -18.7 | 2020-01-02T19:01:23.1458543
|4 | 1 | 4 | 60.0 | 2020-01-05T09:34:18.5893223


## Configuration

The project is containerized, so you can run it with the usual docker-compose commands, however, to make our lives easier, I've created a few commands that can be run in the root of the project.



The command `make run` will use gradle to clean the build, build it again, build the docker container and run it with docker-compose.

After the project is up, you can access the api documentation done with swagger at: http://localhost:8080/swagger-ui/index.html


## Tests

To run the tests you can use the command `make test` in the project root.