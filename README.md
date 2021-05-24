# container-optimizer-demo
Java application to use in presentation about optimization and performance for containers applications

# Presentation

## Slides 

- [Performance Tips for Container Applications - PDF](Performance%20Tips%20for%20container%20applications.pdf)
- [Performance Tips for Container Applications - Power Point](Performance%20Tips%20for%20container%20applications.pptx)

## Article

- [Medium - Performance Tips for Container Applications](https://medium.com/farfetch-tech-blog/performance-tips-for-container-applications-3de605b43ec6)
- [Farfetch Tech Blog - Performance Tips for Container Applications](https://www.farfetchtechblog.com/en/blog/post/performance-tips-for-container-applications/)

# Pre-requisites

- Java JDK 8
- Maven 3.x
- set JAVA_HOME

# Build with Docker

```
mvn clean package
docker build -t demo:1.0.0 .
```

# Run With Docker

```
docker run -it --ulimit nofile=128 --memory 1000MB --cpus 0.5 -e "JAVA_OPTS=-Xms300m -Xmx712 -DcorePoolSize=100 -DmaxPoolSize=120 -DqueueCapacity=300" -p 8080:8080  --name demo demo:1.0.0 
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
