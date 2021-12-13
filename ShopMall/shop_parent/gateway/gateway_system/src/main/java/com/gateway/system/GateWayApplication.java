package com.gateway.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class);
    }

    @Bean
    public KeyResolver ipKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
            }
        };
    }
}
