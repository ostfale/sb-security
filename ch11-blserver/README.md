## Business Logic Server

+ Start Auth Server -> localhost:8080 (starting from mvn block 9090)
+ Start Business Logic Server -> localhost:9091

````shell
curl -H "username:Danielle" -H "password:12345" http://localhost:9091/login  # create OTP in DB
curl -v -H "username:Danielle" -H "code:2359" http://localhost:9091/login  # use code get JWT
# < Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IkRhbmllbGxlIn0.i7Iq1vU7fPjRJBa5zALuzslGo1oLY0OpUytaTJMO5xk

# using jwt token provides access to product page returning string
curl -H "Authorization:eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IkRhbmllbGxlIn0.i7Iq1vU7fPjRJBa5zALuzslGo1oLY0OpUytaTJMO5xk" http://localhost:9091/test
# Test from business logic server!
````

## JSON Webtoken

+ **JWT** = JSON WebToken
+ **JWS** = JSON Web Token signed
+ **JWE** = JSON Web Token encrypted