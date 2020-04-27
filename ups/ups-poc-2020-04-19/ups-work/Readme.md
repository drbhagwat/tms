# API and UI Development and Test Environment

### Network - For connecting two containers

**_Docker Network_**

```bash
> docker network create mytestnetwork
```

**_API_**

```bash
> docker run -it --rm -v $PWD/api:/app -w=/app -v /root/.m2:/root/.m2 maven:3.6.1-jdk-11 mvn -B -DskipTests clean package
```

Run the JAR in a container, name it as t_api
```bash
> docker run --rm -it --name t_api --network mytestnetwork -v $PWD/api/target:/app -w=/app openjdk:11 java -jar api-0.0.1-SNAPSHOT.jar
```


**_UI_**

Create ProxyConf json file, to point to the API service within the network 

```javascript
{
    "/api/*": {
        "target": "http://t_api:8080/",
        "secure": false,
        "logLevel": "debug",
        "changeOrigin": true,
        "pathRewrite": {
            "^/api": "/api"
        }
    }
}

```

Install all dependent node modules by running NPM install

```bash
> docker run -it --rm-v $PWD/tmsui:/app -w=/app node:latest npm install

```

Run the app by connecting to the network

```bash
> docker run -it --name tmsui --rm --network mytestwork -v $PWD/tmsui:/app -w=/app -p 8000:8000 node:latest npm install
```

Now, open browser, and connect to the VM, port 8000

