package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfiguration {

    @Bean
    public RouteLocator constomRoteLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes=builder.routes();

        routes.route("path_route_atguigu",
                r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator constomRoteLocator1(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes=builder.routes();

        routes.route("path_route_atguigu",
                r->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
