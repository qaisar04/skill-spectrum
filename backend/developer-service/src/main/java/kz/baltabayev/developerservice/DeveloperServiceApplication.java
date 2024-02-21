package kz.baltabayev.developerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
public class DeveloperServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeveloperServiceApplication.class, args);
    }
}