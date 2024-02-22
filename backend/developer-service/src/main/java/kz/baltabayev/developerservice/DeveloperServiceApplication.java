package kz.baltabayev.developerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
public class DeveloperServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeveloperServiceApplication.class, args);
    }
}