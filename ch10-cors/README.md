## Terms

### CSRF (cross site request forgery)

Comes into play with POST requests, where CSRF is enabled by default in Spring. 

+ SB add a **CsrfFilter** to generate an UUID token to be used by all following requests

````shell
curl -v http://localhost:8080/hello  
# token: 55e8bddd-4f08-4dcd-9cab-7aa44b2da18e
# Set-Cookie: JSESSIONID=A1A085E54D70AE9AFD8224DB330E7CCA;

$ curl -XPOST http://localhost:8080/hello
{"timestamp":"2021-01-28T07:43:20.896+00:00","status":403,"error":"Forbidden","message":"","path":"/hello"}

$ curl -X POST http://localhost:8080/hello 
-H 'Cookie: JSESSIONID=A1A085E54D70AE9AFD8224DB330E7CCA'  
-H 'X-CSRF-TOKEN: 55e8bddd-4f08-4dcd-9cab-7aa44b2da18e'
POST Hello from CSRF
````