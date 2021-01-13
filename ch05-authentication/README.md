## Use a SecurityContext to retrieve Credentials

````shell
curl -u max:test1234 http://localhost:8080/hello                    # explicit security context
curl -u max:test1234 http://localhost:8080/helloInject              # injected security context
``