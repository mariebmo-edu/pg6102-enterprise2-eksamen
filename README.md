# pg6102-enterprise2-eksamen
Eksamensrepo for PG6102, Enterprise 2

## Nothing works, and I don't know why

Hi Jason! 

I got so far, but in the end, the tests defeated me. If I had another day or week, I'm sure I would've managed to get everything up and running.

I've had a lot of issues with the different services not wanting to recognize the dependencies, and I've spend hours (and days) trying out different versions,
methods, and approaches. I've tried to use the same versions as you, I've tried to use the latest versions of everything, I've tried adding and removing stuff.
Every time I came one step closer, something else broke - mainly with test-related stuff. I believe I spent about 99% fixing errors, and 1% writing code, and I must admit it wore me down having to work on a tight deadline and feeling that nothing is going the way I wanted to.

BUT! I got all the other things to work (services, communication, rabbitmq, pagination, caching etc.), except for circuit breaker. I had major issues where MockMvc refused to Autowire into tests, making it impossible to do any smart integration tests. I tried to make some dummy-tests, butas I'm not able to run them, I'm not sure if they would've worked or not.

I got the integration tests against the database to work just fine, except for the Shipment-service, which didn't like being wired with RabbitListener. After two days of trying to get the tests to work, I had to focus on the implementation of the software. Hopefully what I've done is enought to get some idea of what I wanted to accomplish and see I understand most of the corriculum from the course, and could figure out the rest with a bit more time, but I must admit that I'm disappointed that I wasn't able to get everything to work the way I hoped.

I hope it's not too much of a hassle looking through the code to get an overview of how it works - I promise it 100% works 98% of the time! 

I've attached the postman-collection, so you can give it a go with the best kind of testing - manual labor.

Merry Christmas! 

## Criteria

**Minimum for E**
- [x] Order-Service
- [x] Payment-Service
- [x] Shipping-Service
- [x] REST-Endpoints with ResponseEntities
- [x] docker-compose.yml with databases + rabbitmq
- [ ] tests

***Comments***
I had -a lot- of issues with libraries in the project. Neither MockMvn, WireMock, nor mockk wanted to play along, and refused to be implemented. I've tried to make some "dummy" requests (that isn't working on my end due to MockMvc/mockk), but hopefully they'll give some impression that I have some idea of how they should be implemented. I was not able to test them, so they might be wrong.

![image](https://user-images.githubusercontent.com/23049454/203850306-09a6e84f-7f72-4bff-9286-a8adf55538fe.png)
No matter what I've tried, I can't get MockMvc to work. I've added all the necessary dependencies, and "normal" tests works fine.

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
- [x] Pagination for Queries

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
