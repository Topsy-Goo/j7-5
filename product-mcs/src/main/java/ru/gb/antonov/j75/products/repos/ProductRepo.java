package ru.gb.antonov.j75.products.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.antonov.j75.products.entities.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>
{
    Optional<List<Product>> findAllByIdBetween (Long from, Long to);
}
