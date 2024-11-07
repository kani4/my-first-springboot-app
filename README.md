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

