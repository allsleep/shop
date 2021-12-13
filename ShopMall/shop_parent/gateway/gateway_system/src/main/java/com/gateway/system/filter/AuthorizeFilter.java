package com.gateway.system.filter;

import com.gateway.system.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;



@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        ServerHttpResponse response = exchange.getResponse();


        if (request.getURI().getPath().contains("/admin/login") ){
            return chain.filter(exchange); //放行
        }

        HttpHeaders headers = request.getHeaders();

        String token = headers.getFirst("token");

        if (StringUtils.isEmpty(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        try{
            JwtUtil.parseJWT(token);
        }catch(Exception e){
            e.printStackTrace();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }
}
