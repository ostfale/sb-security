## Add Filter to FilterChain

### Simple Request filter (RequestValidationFilter)

+ Filter the existence of a flag in the request header and  will be executed before 
+ Logging filter can be executed after successful authentication -> log Request-Id in console

````shell
curl -v http://localhost:8080/hello                     # error-> HTTP/1.1 400
curl -H "Request-Id:1234" http://localhost:8080/hello   # returns controller response
````

### Replace Filter

Replacing a filter at the same position means both filter are going to be executed in undetermined order. 
Example: StaticHeaderKey -> here defined in resource file

````shell
curl -H "Authentication:SD9dICjl1e" http://localhost:8080/hello  # works
````