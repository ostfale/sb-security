## Add Filter to FilterChain

### Simple Request filter (RequestValidationFilter)

+ Filter the existence of a flag in the request header and  will be executed before 
+ Logging filter can be executed after successful authentication -> log Request-Id in console

````shell
curl -v http://localhost:8080/hello                     # error-> HTTP/1.1 400
curl -H "Request-Id:1234" http://localhost:8080/hello   # returns controller response
````