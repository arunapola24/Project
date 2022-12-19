###
1. gradle version - 7.5.1
2. jdk - 17

###Assumptions:
####Input payload

```
{
 "countries":"US,CA"
}
```

###Instructions to run the application:
1. gradlew clean build
2. docker build -t takehome:1.0 .
3. docker run -d -p 8080:8080 -t takehome:1.0
