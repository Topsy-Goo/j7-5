package ru.gb.antonov.j75.front.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.antonov.j75.dtos.ProductDto;

import java.util.List;

/** {@code @FeignClient("product-mcs")} означает, что класс, реализующий этот интерфейс, вызывая перечисленные ниже методы, не будет вычислять возвращаемое значение, а будет запрашивать его у указанного в аннотации мкс.<p>
 Выходит, что у нас должно быть столько интерфейсов, сколько мкс мы «мимикрируем».<p>
 Ещё примечательно, что фейн-контроллер, который работает в паре с этим интерфейсом, не реализует этот интерфейс, а только инжектит его себе. Видимо, этот интерфейс тоже «с сюрпризом», как интерфейсы-репозитории, только сюрприз тут другой. */
@FeignClient("product-mcs")
public interface ProductClient
{
/** Тут, видимо, всё работает по принципу «контроллер-наоборот»: {@code @PathVariable} указывает значение, которое нужно вставить в адресную строку при вызове {@code product-mcs}, а тип возвращаемого значения ({@code String}) это — тип, к которому будет приведено значение, полученное от {@code product-mcs} в ответе.<p>
    Здесь в аннотации мы указываем «адрес», по которому мы будем обращаться к продакт-мкс:<br>{@code /prod/{id}}.<p>
    В фейн-контроллере в аннотации мы указываем «адрес», по которому фронт будет обращаться к нам:<br>{@code /product/{id}}. */
    @GetMapping ("/prod/{id}")
    ProductDto lookForProductById (@PathVariable (value="id") Long id);

    @RequestMapping ("/prod")
    List<ProductDto> lookForAllProducts ();
}
