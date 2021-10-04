package ru.gb.antonov.j75.products.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.antonov.j75.products.entities.ProductsCategory;

import java.util.Optional;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductsCategory, Integer>
{
    Optional<ProductsCategory> findByName (String name);
}
