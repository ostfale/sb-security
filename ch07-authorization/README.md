## Using hasAuthority

+ John has only READ and Linda also WRITE permission

````java
 http.authorizeRequests().anyRequest().hasAuthority("WRITE");
````

`curl -u john:test1234 http://locacalhost:8080/hello`

{"timestamp":"2021-01-22T06:40:05.139+00:00","status":403,"error":"Forbidden","message":"","path":"/hello"}

`curl -u linda:test4321 http://locacalhost:8080/hello`

Hello Authorization!