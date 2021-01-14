## Use a SecurityContext to retrieve Credentials

````shell
curl -u max:test1234 http://localhost:8080/hello                    # explicit security context
curl -u max:test1234 http://localhost:8080/helloInject              # injected security context
````

### Security Context Models

+ MODE_THREADLOCAL (default)
+ MODE_INHERITEDTHREADLOCAL (async)
+ MODE_GLOBAL (standalone application)

### DelegatingSecurityContextCallable

Provides Security Context to external threads

````shell
curl -u max:test1234 http://localhost:8080/ciao                    # delegated security context
````

Provides Security Context to ThreadPool 

````java
ExecutorService executorService = Executors.newCachedThreadPool();
executorService = new DelegatingSecurityContextExecutorService(executorService);
````

````shell
curl -u max:test1234 http://localhost:8080/hola                    # delegated security context
````