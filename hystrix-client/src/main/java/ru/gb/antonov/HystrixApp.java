package ru.gb.antonov;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/** Если, например, через постмана послать этому микросервису (hystrix-client) запрос типа<br>
{@code http://localhost:12211/demo/client}, то он сделает запрос на<br>
{@code http://eureka-client/abcr} клиенту eureka-client, а тот ответит hystrix'у строкой "ABCR", а hystrix отправит эту строку постману. Проверено, работает.<p>
Вообще hystrix здесь используется немного не по назначению. Просто его тоже можно использовать в качестве клиента эврики. Прежде всго Хистрикс является прерывателем цепи: если несколько мкс связаны в цепь, то прерыватели цепи препятствуют растпространению ошибки по этой цепи, возвращая вместо ошибки какое-то значение. В данном случае Хистрикс будет возвращать строку "zero".  */

@SpringBootApplication
@RestController       //< Как оказалось, основной класс приложения может выполнять роль контроллера.
@EnableEurekaClient
@EnableCircuitBreaker //< прерыватель цепи (способность этого микросервиса)
public class HystrixApp
{
    @Autowired
    private RestTemplate restTemplate;


/** Этот метод даёт бин, который инжектится в этот же самый класс.
*/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () { return new RestTemplate(); }

/** Вместо того, чтобы использовать адрес типа {@code http://localhost:88888/abcr}, мы в адрес вставляем имя клиента эврики, к которому хотим обратиться. В этом нам помогает {@code @LoadBalanced} в метода {@code restTemplate()}.  */
    @HystrixCommand (fallbackMethod = "demoFallback")
    @GetMapping ("/demo/client")
    public String demo ()
    {
        //     restTemplate.getForObject ("http://localhost:88888/abcr", String.class);
        return restTemplate.getForObject ("http://eureka-client/abcr", String.class);
    }

    public String demoFallback () { return "zero"; }

    public static void main (String[] args) { SpringApplication.run (HystrixApp.class, args); }
}
