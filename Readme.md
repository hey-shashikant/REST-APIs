# REST-APIs

### Objectives : You will learn how to ...

- Create REST APIs/ Web Services with Spring
- Discuss REST concepts, JSON and HTTP messaging
- Install REST client tool: Postman
- Develop REST APIs/ Web Services with @RestController
- Build a CRUD interface to the database with Spring REST

### REST HTTP Basics

Most common use of REST is over HTTP. Below is the list of HTTP methods for CRUD operations.
- POST - Create a new entity
- GET - Read a list of entities or single entity
- PUT - Update an existing entity
- DELETE - Deleting an existing entity

### HTTP Request Message

It consists of three areas
- Request Line - the HTTP command
- Header Variables - request metadata
- Message body - contents of message

### HTTP Response Message

It also consists of three areas
- Response Line - server protocol and status code
- Header variables - response metadata
- Message body - contents of message

### HTTP Response
| Code Range | Description   |
|------------|---------------|
| 100-199    | Informational |
| 200-299    | Successful    |
| 300-399    | Redirection   |
| 400-499    | Client Error  |
| 500-599    | Server Error  |

### MIME Content Types

- The message format is described by MIME content type
- Multipurpose Internet Mail-Extention
- Basic Syntax: type/sub-type
- Examples
    1. text/html, text/plain
    2. application/json, application/xml, ....

NOTE : When we add @RestController Annotation it adds the REST support.

### Java JSON Data Binding

- Data binding is the process of converting JSON data to a java POJO
- Also known as Mapping, Serialization/ Deserialization, Marshalling/ Unmarshalling.
- Spring uses the Jackson Project behind the scenes, jackson handles data binding between JSON and Java POJO

### Path Variables

- Retrieve a single student by id /api/students/{studentId}
- This studentId is known as path variable

### Exception Handling

- Create a custom error response class
- Create a custom exception class
- Update REST service to throw exception if student not found
- Add an exception handler method using @ExceptionHandler



