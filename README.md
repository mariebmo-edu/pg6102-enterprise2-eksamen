# pg6102-enterprise2-eksamen
Eksamensrepo for PG6102, Enterprise 2

**Minimum for E**
- [x] Order-Service
- [x] Payment-Service
- [x] Shipping-Service
- [x] REST-Endpoints with ResponseEntities
- [x] docker-compose.yml with databases + rabbitmq
- [x] tests

***Comments***
I had -a lot- of issues with libraries in the project. Neither MockMvn nor WireMock wanted to play along, and refused to be implemented. I've tried to make some "dummy" requests (that isn't working on my end due to MockMvc/Wiremock), but hopefully they'll give some impression that I have some idea of how they should be implemented. I was not able to test them, so they might be wrong.

![image](https://user-images.githubusercontent.com/23049454/203850306-09a6e84f-7f72-4bff-9286-a8adf55538fe.png)
No matter what I've tried, I can't get MockMvc to work. I've added all the neccessary dependencies, and "normal" tests works fine. 

![image](https://user-images.githubusercontent.com/23049454/203857165-7780eec7-3e85-433e-87ce-2613cc937302.png)
I have a similar problem with Wiremock, where the application refuses to import the library, even with all three of the wiremock-dependencies included.

**Minimum for D**
I have the same issue with RabbitMq as with MockMc and Wiremock, not being able to implement the integration.
- [x] Order -> Shipping communication with RabbitMq
- [ ] RabbitMq testcontainers

***Comments***

**Minimum for C**
- [x] Gateway-Service on port 8080
- [x] Caching

***Comments***

**Minimum for B**
- [x] Discovery-Service w/Eureka
- [ ] Pagination for Queries

***Comments***

**Minimum for A**
- [x] Custom exceptions
- [x] Global Error Handeler with @ControllerAdvice
- [ ] CircuitBreakers
- [x] Dockerfiles for every service

***Comments***
CircuitBreakers
- I tried implementing CircuitBreakers in the project, but due to the gateway, it was difficult to make it work. I tried to implement the circuitbreaker in the GatewayService (as can be seen with the CircuitBreakerConfiguration and FallbackConfiguration-files, and I also added the circuitbreaker to the .yml of the config with the filter, but I couldn't get it to work. ex: 

          filters:
            - name: CircuitBreaker
              args:
                name: payment
                fallbackUri: forward:/payment-fallback
