package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Nacos8004Application {

    public static void main(String[] args) {
        SpringApplication.run(Nacos8004Application.class, args);
    }
}
