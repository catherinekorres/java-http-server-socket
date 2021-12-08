# Java Socket HTTP Server 
Simple project of a HTTP Server with Java Socket

## 📋 Description
Once up, the server socket runs on port `:8081`.

Depending on the URL used to access the server, you will get a different HTTP Response.


There are only 2 responses mapped:
- `200 - OK`
  - returned when root URL `/` is accessed 
- `404 - Not Found`
  - returned when any URL path, other than root `/`, is accessed

## 📦 Requirements
- Java SE Development Kit (available <a href="https://www.oracle.com/java/technologies/downloads/#java11" target="_blank">here</a>)

## 🛠️ How to run
After cloning the repository, go to the directory `/src`, where the `.java` files
are and then, compile them:
```
cd src &&
javac -d ../out/production/http-socket-server HttpSocketServer.java HttpResponse.java
```

In the command above, you set the path `/out/production/http-socket-server` where the `.class` files will be created after the compilation is over. 

Once finished, go to the directory defined for the `.class` files:
```
cd ../out/production/http-socket-server
```
And run the project with the following command:
```
java HttpSocketServer
```
That's it! ✨️ The server is up.

## 💻 Testing
With the server running, you can test both of the HTTP response scenarios.

- `200 - OK`
  - In your browser, go to `http://localhost:8081/`. 
  You should see a HTML page with a welcome title
- `404 - Not Found`
  - In your browser, go to `http://localhost:8081/<path>`. 
  You can put any string in `<path>`.
  You should see a HTML page that states `404 - Not Found`