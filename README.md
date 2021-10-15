# Books

## Set up

Requirements

* Node: 14.18.1
* npm: 6.14.15
* Java 11
* Maven 3.6.3

## Development

Run SpringBoot server:

```
mvn spring-boot:run
```

Run Angular client

```
cd frontend/
npm install
npm start
```

Navigate to http://localhost:4200/books

## Production

Build client
```
cd frontend/
npm install
npm build --prod
mkdir ../src/main/resources/static/
cp -r dist/* ../src/main/resources/static/
```

Build server
```
mvn package
java -jar target/books-0.1.0.jar 
```

## Production (with Docker)

```
docker build -t books:v1 .
docker run -p 8443:8443 books:v1
```