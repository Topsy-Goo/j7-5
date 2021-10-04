package ru.gb.antonov.j75.products.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import ru.gb.antonov.j75.dtos.ProductDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name="products")
public class Product
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="price")
    private double price;

    @Column(name="rest")
    private int rest;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private ProductsCategory category;

    @CreationTimestamp
    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name="updated_at", nullable=false)
    private LocalDateTime updatedAt;
//----------------------------------------------------------------------
    public Product (){}

    public ProductDto toProductDto () { return new ProductDto (id, title, price, category.getName ()); }
}
