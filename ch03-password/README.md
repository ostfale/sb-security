## Provided Implementations

+ `NoOpPasswordEncoder`         - doesn't encode (deprecated)
+ `StandardPasswordEncoder`     - SHA-256 (deprecated -> hashing not strong enough)
+ `Pbkdf2PasswordEncoder`       - uses PBKDF2
+ `BCryptPasswordEncoder`       - uses bcrypt hashing
+ `SCryptPasswordEncoder`       - uses scrypt hashing
