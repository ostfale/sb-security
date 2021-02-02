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

### Store Token in own repositoy

+ use JPARepository

````shell
$ curl -H "X-IDENTIFIER:12345" http://localhost:8080/hello  # create entry in DB 
-> GET Hello from CSRF

$ curl -XPOST -H "X-IDENTIFIER:12345" -H "X-CSRF-TOKEN:2277d995-f67c-46da-8aa9-fc3936f1eaa7"  http://localhost:8080/hello # read token from db
POST Hello from CSRF

$ curl -XPOST http://localhost:8080/hello   # without token = error
{"timestamp":"2021-02-01T07:31:20.890+00:00","status":403,"error":"Forbidden","message":"","path":"/hello"}
````

### CORS (cross-origin resource sharing)

Prohibit applications to make calls from different domains. Works based on HTTP headers:
+ **Access-Control-Allow-Origin** => specify foreign domains
+ **Access-Control-Allow-Methods** => different domains for specific methods
+ **Access-Control-Allow-Headers** => limitations for headers to be used

Adding @CrossOrigin specifies allowed origin for the request. 

````java
@PostMapping("/test")
@ResponseBody
@CrossOrigin("http://localhost:8080")
public String test() {
    logger.info("Test method called!");
    return "HELLO";
}
````

More flexible to make configuration in ProjectConfig.

````java
http.cors(c -> {
    CorsConfigurationSource source = request -> {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("example.org", "example.com"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        return configuration;
    };
    c.configurationSource(source);
});
````