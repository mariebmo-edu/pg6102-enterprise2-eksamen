# pg6102-enterprise2-eksamen
Eksamensrepo for PG6102, Enterprise 2

**Minimum for E**
- [x] Order-Service
- [x] Payment-Service
- [x] Shipping-Service
- [x] REST-Endpoints with ResponseEntities
- [x] docker-compose.yml with databases + rabbitmq
- [ ] tests

***Comments***

**Minimum for D**
- [x] Order -> Shipping communication with RabbitMq
- [ ] RabbitMq testcontainers

***Comments***

**Minimum for C**
- [x] Gateway-Service on port 8080
- [ ] Caching

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
