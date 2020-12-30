## commands

+ default user : user
+ default pw: generated

cCurl creates a Base64 encoded string which is passed to the header. 

````shell
curl http://localhost:8080/hello                                                  # returns JSon with Unauthorized 
curl -u user:db5aaa4c-c0c0-4a27-9535-bcb6893d4446 http://localhost:8080/hello     # authorized access

curl  -H "Authorization: Basic <base64 encoded>" http://localhost:8080/hello      # same as above
````