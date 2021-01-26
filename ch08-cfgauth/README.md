## Matcher Methods

+ **MVC matchers** - MVC expressions to select endpoints
+ **Ant matchers** - Ant expressions to select endpoints
+ **regex matchers** - regular expressions to select endpoints

## Commands 

### HTTP Methods

````java
http.csrf().disable(); // enable POST for testing only

.mvcMatchers(HttpMethod.GET, "/a").authenticated()
.mvcMatchers(HttpMethod.POST, "/a").permitAll()
.anyRequest().denyAll();    
````

````shell
curl -XPOST http://localhost:8080/a                   # POST works
curl - XGET http://localhost:8080/a                   # denied
curl -u linda:test4321 -XGET http://localhost:8080/a  # works
````

### Path matcher

Use MVC matchers over ANT matchers. Different behaviour for /hello and /hello/!

+ /a/**/b               all subdirectories
+ /a/*/b                one level subdirectory
+ "{code:^[0-9]*$}"     regex checking that a path variable contains only digits   

````java
.mvcMatchers("/a/b/**")                                     // curl /a permitted, /a/b, /a/b/c not
.mvcMatchers("/a/*/c")                                      // match a/b/c or a/d/c not a/b/d/c
        
.mvcMatchers("/product/{code:^[0-9]*$}").permitAll();       // curl /product/12a fail and /product/12 success 
.anyRequest().permitAll();
````