package ru.gb.antonov.j75.products.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.antonov.j75.dtos.ProductDto;
import ru.gb.antonov.j75.dtos.errorhandlers.ResourceNotFoundException;
import ru.gb.antonov.j75.products.entities.Product;
import ru.gb.antonov.j75.products.repos.ProductCategoryRepo;
import ru.gb.antonov.j75.products.repos.ProductRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepo         productRepo;
    private final ProductCategoryRepo productCategoryRepo;

    @Transactional
    public ProductDto getProductById (Long id)
    {
        String errMessage = "Не найден продукт с id = "+ id;
        Product p = productRepo.findById (id)
                               .orElseThrow (()->new ResourceNotFoundException (errMessage));
        return p.toProductDto();
    }

    @Transactional
    public List<ProductDto> findAllProducts ()
    {
        return productRepo.findAll ()
                          .stream()
                          .map (Product::toProductDto)
                          .collect (Collectors.toList ());
    }
}
