package snr.student1012.gatewayservice

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.timelimiter.TimeLimiterConfig
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder
import org.springframework.cloud.client.circuitbreaker.Customizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration


@Configuration
class CircuitBreakerConfiguration {

    val timeout: Duration = Duration.ofSeconds(3);

    @Bean
    fun defaultCustomizer(): Customizer<Resilience4JCircuitBreakerFactory> {

        val circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(50f)
            .waitDurationInOpenState(Duration.ofSeconds(2))
            .slidingWindowSize(2)
            .build()

        val timeLimiterConfig = TimeLimiterConfig.custom()
            .timeoutDuration(timeout)
            .build()

        return Customizer<Resilience4JCircuitBreakerFactory>{
            factory -> factory.configureDefault { id -> Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(circuitBreakerConfig)
                .timeLimiterConfig(timeLimiterConfig)
                .build()
            }
        }
    }
}