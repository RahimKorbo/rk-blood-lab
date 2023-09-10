# rk-blood-lab
This repository will contain all blood report related API


# API CURLS

### POST API for Login

curl --location --request POST 'http://localhost:8080/api/v1/auth/auth' \
--header 'Content-Type: application/json' \
--data-raw '{

    "email" : "admin@mail.com",
    "password" : "password" 
}'


### POST API for report for starting testing in local

curl --location --request POST 'http://localhost:8080/api/report' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBtYWlsLmNvbSIsImlhdCI6MTY5NDMyMzk4NCwiZXhwIjoxNjk0NDEwMzg0fQ.Lvsiv9SVFevBcPDtAB-jcWE8oXA3t3kXRNYV3gcRS2w' \
--header 'Content-Type: application/json' \
--data-raw '{

    "patientName":"rakesh",
    "patientAge":"29",
    "patientSex":"male",
    "referredBy":"Dr.Shailesh Jain",
    "reportCreatedBy":"2023-09-09"
}'