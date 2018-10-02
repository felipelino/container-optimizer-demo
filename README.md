# container-optimizer-demo
Java application to use in presentation about optimization and performance for containers applications

# Pre-requisites

- Java JDK 8
- Maven 3.x
- set JAVA_HOME

# Build with Docker

```
mvn clean package
docker build -t continer-optimizer-demo:1.0.0 .
```

# Run With Docker

```
docker run -it --ulimit nofile=1024:1024 -m 500MB --cpus 1.0  -e "JAVA_OPTS=-DcorePoolSize=2 -DmaxPoolSize=2 -DqueueCapacity=3" -p 8080:8080  --name demo continer-optimizer-demo:1.0.0 
```

# API Definition

## Status

*Request* 

```
curl -v -X GET  http://localhost:8080/status
```

*Response*

```
{
    "isRunning": "true"
}
```

## Sort

*Request*

```
curl -v -X POST \
  http://localhost:8080/sort \
  -H 'content-type: application/json' \
  -d '{
	"intList": [{
		"list": [8, 9, 4, 12, 56, 78, 90, 56, 34, 74]
	}, {
		"list": [8, 9, 4, 12, 56, 78, 90, 56, 34, 74]
	}, {
		"list": [8, 9, 4, 12, 56, 78, 90, 56, 34, 74]
	}, {
		"list": [8, 9, 4, 12, 56, 78, 90, 56, 34, 74]
	}, {
		"list": [8, 9, 4, 12, 56, 78, 90, 56, 34, 74]
	}]
}'
```

*Response*

```
{
	"intList": [{
			"list": [
				4,
				8,
				9,
				12,
				34,
				56,
				56,
				74,
				78,
				90
			]
		},
		{
			"list": [
				4,
				8,
				9,
				12,
				34,
				56,
				56,
				74,
				78,
				90
			]
		},
		{
			"list": [
				4,
				8,
				9,
				12,
				34,
				56,
				56,
				74,
				78,
				90
			]
		},
		{
			"list": [
				4,
				8,
				9,
				12,
				34,
				56,
				56,
				74,
				78,
				90
			]
		},
		{
			"list": [
				4,
				8,
				9,
				12,
				34,
				56,
				56,
				74,
				78,
				90
			]
		}
	]
}
```
