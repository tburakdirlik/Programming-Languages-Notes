# Simple Application to use Spring Security

Application create in Spring Security allows send credentials like 
(username and password) verifies if pass user exist. If exist application generate
token which consist information about user authorities.

Application have a fake database with three type of users:
- linda {"username" : "linda", "password" : "password"}, this user has
ADMIN authorities to  STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE
- tom {"username" : "tom", "password" : "password"}, this user has
ADMINTRAINEE authorities to STUDENT_READ, COURSE_READ
- annasmith {"username" : "annasmith", "password" : "password"}, this user has
STUDENT authorities 

Implementation allows to in easy way add real database for example : Mongo, Postgres etc.

## If you want generate token

Send POST request on endpoint http://localhost:8080/login with body for example:
'{
    "username" : "linda",
    "password" : "password"
}'

## Protip
To view the permissions you need to go https://jwt.io/ and paste generated token,
on the right side in 'Payload' section you can see all authorities.

## If you want get student list 
Send GET request
on http://localhost:8080/management/api/v1/students
and set type Authorization on Bearer Token and paste generated previous token.
If token will be correct response from server will be contain information 
about student list

## Recommended link
https://www.youtube.com/watch?v=her_7pa0vrg

