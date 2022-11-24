package snr.student1012.gatewayservice

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

@Configuration
class FallbackConfiguration {

    @Bean
    fun routerFunction() : RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/payment-fallback"), this::handlePaymentFallback)
            .andRoute(RequestPredicates.GET("/payment-fallback"), this::handlePaymentFallback)
            .andRoute(RequestPredicates.POST("/shipping-fallback"), this::handleShippingFallback)
            .andRoute(RequestPredicates.GET("/shipping-fallback"), this::handleShippingFallback)
            .andRoute(RequestPredicates.POST("/order-fallback"), this::handleOrderFallback)
            .andRoute(RequestPredicates.GET("/order-fallback"), this::handleOrderFallback)
    }

    fun handlePaymentFallback(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body("Payment service is not available", String::class.java)
    }

    fun handleShippingFallback(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body("Shipping service is not available", String::class.java)
    }

    fun handleOrderFallback(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body("Order service is not available", String::class.java)
    }
}