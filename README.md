This application focuses on implementing REST endpoints using springboot. Springboot provides a 
convenient and streamlined way to build RESTful APIs.

This application is implemented using (Controller - Service - Repository) pattern

1. Repository layer - Storage of entity in the system. Some dummy products are created here.
2. Service layer - It delegates calls to the repository layer.
3. Controller layer - It manages the REST interface to the business logic. RequestMapping provides a base path for endpoints.

Classes in the application
-----------------------------
1. Product class - Contains members, getter and setter methods of the product.
2. MyFirstController class - It has various HTTP endpoints that returns what the service class provides.
3. ProductRepository class - It contains all the dummy product information and the methods to retrieve product data.
4. ProductService class - It gets the requested product object from repository and return it to controller.

The endpoints implemented are GET, PUT, POST, DELETE and PATCH. Postman is used for testing the endpoints.

Features in the application
------------------------------
1. H2 database has been used to store data
2. Feature toggle has been added for each product (active or inactive)

How to run the application
------------------------------
1. java version 22 has been used
2. The application will be started in port 8080
3. Some of the end points that can be hit are,
   a. GET http://localhost:8080/products - gives the list of all the products
   b. GET http://localhost:8080/products/1 - gives the product with id "1"
   c. POST http://localhost:8080/products - adds new product to the database 
      Body - {
        "id": 8,
        "name": "Samsung note",
        "price": 567.99,
        "active": true
      })
   d. PUT http://localhost:8080/products - updates existing product
      Body - {
       "id": 8,
       "name": "Samsung note",
       "price": 567.99,
       "active": true
      })
   e. DELETE http://localhost:8080/products/7 - deletes product with ID "7"
   f. PATCH http://localhost:8080/products/8 - updates product info based on ID
      Body - {
       "price": 499
      })
4. H2 database can be accessed at - http://localhost:8080/h2-console - username - sa (with no password at the moment)
5. "Active" property can be made true or false in the database or during the patch and it will act as a feature toggle for the item.
