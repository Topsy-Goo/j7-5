package ru.gb.antonov.j75.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.antonov.j75.dtos.ProductDto;
import ru.gb.antonov.j75.products.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService productService;

    @GetMapping ("/prod/{id}")
    public ProductDto getProductById (@PathVariable (value="id") Long id)
    {
        return productService.getProductById (id);
    }

    @GetMapping ("/prod")
    public List<ProductDto> getAllProducts ()
    {
        return productService.findAllProducts ();
    }
}
