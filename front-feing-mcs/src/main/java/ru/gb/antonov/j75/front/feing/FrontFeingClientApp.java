package ru.gb.antonov.j75.front.feing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //< необходимо включить для feign-мкс
public class FrontFeingClientApp
{
    public static void main (String[] args) { SpringApplication.run (FrontFeingClientApp.class, args); }
}

