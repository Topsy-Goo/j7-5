package ru.gb.antonov.j75.products.entities;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="categories")
public class ProductsCategory
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @CreationTimestamp
    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name="updated_at", nullable=false)
    private LocalDateTime updatedAt;
//-------- неколонки
    @OneToMany(mappedBy="category")
    private List<Product> product62s;

    public ProductsCategory () {}
}
