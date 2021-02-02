## commands

+ default user : user
+ default pw: generated

cCurl creates a Base64 encoded string which is passed to the header. 

````shell
curl http://localhost:8080/hello                                                  # returns JSon with Unauthorized 
curl -u user:db5aaa4c-c0c0-4a27-9535-bcb6893d4446 http://localhost:8080/hello     # authorized access

curl  -H "Authorization: Basic <base64 encoded>" http://localhost:8080/hello      # same as above
````

### Certificate formats

Use either of keytool or OpenSSL tools to generate the certificates from the command line.

+ **PKCS12** : Public Key Cryptographic Standards is a password protected format that can contain multiple certificates and 
  keys; it's an industry-wide used format
+  **JKS** : Java KeyStore is similar to PKCS12; it's a proprietary format and is limited to the Java environment.

### Certificate for https

Self-signed certificate to enable https locally. Creates first a public (cert.pem) and a private (key.pem) key and use these to
create a certificate

+ put certificate in resources
+ update properties in resources

````shell
openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem  -days 365                   # create key
openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"   # create certificate

curl -k -u user:db5aaa4c-c0c0-4a27-9535-bcb6893d4446 https://localhost:8080/hello             # use https
````

### InMemoryUserDetailsService

To override UserDetailsService forces to override PasswordEncoder too!

````shell
curl -k -u max:test123 https://localhost:8080/hello                                           # use TLS with the created user
````