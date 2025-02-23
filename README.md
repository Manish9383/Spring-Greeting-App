Greeting App API Endpoints Guide
Use Case 1: Basic HTTP Methods

    GET Request

curl -X GET http://localhost:8080/greeting

    Response: {"message": "Hello, GET request received!"}

POST Request

curl -X POST http://localhost:8080/greeting

    Response: {"message": "Hello, POST request received!"}

PUT Request

curl -X PUT http://localhost:8080/greeting

    Response: {"message": "Hello, PUT request received!"}

DELETE Request

    curl -X DELETE http://localhost:8080/greeting

        Response: {"message": "Hello, DELETE request received!"}

Use Case 2: Get Greeting Message

    Retrieve a greeting message

    curl -X GET http://localhost:8080/greeting/greetingg

        Response: {"message": "Hello World"}

Use Case 3: Get Personalized Greeting Message

    With First Name

curl -X GET "http://localhost:8080/greeting/param?firstName=Manish"

    Response: {"message": "Hello, Manish!"}

With Last Name

curl -X GET "http://localhost:8080/greeting/param?lastName=Patel"

    Response: {"message": "Hello, Patel!"}

With First & Last Name

    curl -X GET "http://localhost:8080/greeting/param?firstName=Manish&lastName=Patel"

        Response: {"message": "Hello, Manish Patel!"}

Use Case 4: Save Greeting Message

    Save a greeting message

curl -X POST "http://localhost:8080/greeting/params?firstName=Manish&lastName=Patel"

    Saves a greeting message in the database.

View Data in H2 Console

    Open: http://localhost:8080/h2-console
    Enter JDBC URL: jdbc:h2:mem:greetingdb
    Run the SQL query:

        SELECT * FROM greetings;

Use Case 5: Fetch Greeting by ID

    Get a greeting by ID

curl -X GET "http://localhost:8080/greeting/1"

Add a custom greeting

    curl -X POST "http://localhost:8080/greeting/add?message=HelloSpringBoot"

        Response: Saves "HelloSpringBoot" in the database.

Use Case 6: Get All Greetings

    Retrieve all saved greeting messages

    curl -X GET http://localhost:8080/greeting/all

        Response: List of all greetings from the database.

Use Case 7: Update a Greeting

    Update a greeting by ID

    curl -X PUT "http://localhost:8080/greeting/update/1?message=Updated Message"

        Response: The greeting message with ID 1 will be updated.

Use Case 8: Delete a Greeting

    Delete a greeting by ID

curl -X DELETE "http://localhost:8080/greeting/delete/1"

    Response: "Greeting deleted successfully"