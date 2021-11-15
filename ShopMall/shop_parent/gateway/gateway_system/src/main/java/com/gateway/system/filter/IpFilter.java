package com.gateway.system.filter;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.net.InetSocketAddress;

@Component
public class IpFilter implements GlobalFilter, Ordered {

    // 具体业务逻辑

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        log.info("通过了第一次过滤");
        ServerHttpRequest request = exchange.getRequest();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
//        assert remoteAddress != null;
//        log.info("ip" + remoteAddress.getHostName());
        System.out.println("ip:" + remoteAddress.getHostName()+" addr:" + remoteAddress.getAddress()+ " port:" +remoteAddress.getPort());
        return chain.filter(exchange);
    }

    // 过滤器的执行优先级
    @Override
    public int getOrder() {
        return 1;
    }
}
