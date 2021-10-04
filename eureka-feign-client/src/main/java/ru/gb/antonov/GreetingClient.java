package ru.gb.antonov;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/** {@code @FeignClient("eureka-client")} означает, что класс, реализующий этот интерфейс, вызывая перечисленные ниже методы, не будет вычислять возвращаемое значение, а будет запрашивать его у указанного в аннотации мкс. */
@FeignClient("eureka-client")
public interface GreetingClient
{
    @GetMapping ("/greeting")
    String greeting ();

    @GetMapping ("/parametrized/{id}")
    String parametrized (@PathVariable (value = "id") String id);
}
