package ru.gb.antonov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //< необходимо включить для feign-мкс
public class EurekaFeignClientApp
{
    public static void main (String[] args)
    {
        SpringApplication.run (EurekaFeignClientApp.class, args);
    }
}

