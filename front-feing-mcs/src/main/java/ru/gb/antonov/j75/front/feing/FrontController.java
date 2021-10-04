package ru.gb.antonov.j75.front.feing;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.antonov.j75.dtos.ProductDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FrontController
{
    private final ProductClient productFeingClient;

/** Нам приходит запрос найти товар по его id. Мы перенаправляем его в {@code product-mcs}, получаем от {@code product-mcs} ответ в виде JSON'а и передаём автору запроса этот JSON.<p>
    Здесь в аннотации мы указываем «адрес», по которому фронт будет обращаться к нам:<br>{@code /product/{id}}.<p>
    В интерфейсе в аннотации мы указываем «адрес», по которому мы будем обращаться к продакт-мкс:<br>{@code /prod/{id}}. */
    @RequestMapping ("/product/{id}")   //http://localhost:8191/product/1
    ProductDto feingProductIdRequest (@PathVariable (value="id") Long id)
    {
        return productFeingClient.lookForProductById (id);
    }

    @RequestMapping ("/product")   //http://localhost:8191/product
    List<ProductDto> feingProductIdRequest ()
    {
        return productFeingClient.lookForAllProducts ();
    }
}
