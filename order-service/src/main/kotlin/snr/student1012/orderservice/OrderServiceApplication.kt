package snr.student1012.orderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaClient
class OrderServiceApplication{
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate? {
        val requestFactory = SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10_000)
        return RestTemplate(requestFactory)
    }

}

fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)
}
