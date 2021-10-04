package ru.gb.antonov.j75.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import static ru.gb.antonov.j75.dtos.Factory.PROD_TITLELEN_MAX;
import static ru.gb.antonov.j75.dtos.Factory.PROD_TITLELEN_MIN;

//@Data  < в общем модуле (и в дюбом модуле многомодульного проекта, на который кто-то ссылается
//         следует избегать автогенерации кода при пом ломбока и ему подобных утилит.)
public class ProductDto
{
    private Long productId;

    @NotNull (message="Не задано название товара!")
    @Length (min= PROD_TITLELEN_MIN, max= PROD_TITLELEN_MAX,
             message="Длина названия товара: 3…255 символов!")
    private String title;

    @PositiveOrZero (message="Цена товара должна быть НЕОТРИЦАТЕЛЬНЫМ числом!")
    private double price;

    @NotNull (message="Не указано название категории товара!")
    private String category;
//--------------------------------------------------------------
    public ProductDto (){}

    public ProductDto (long pId, String pTitle, double pPrice, String pCategory)
    {
        productId = pId;
        title     = pTitle;
        price     = pPrice;
        category  = pCategory;
    }
//-------------- Геттеры и сеттеры -----------------------------
    public Long getProductId () { return productId; }
    public void setProductId (Long productId) { this.productId = productId; }

    public String getTitle () { return title; }
    public void setTitle (String title) { this.title = title; }

    public double getPrice () { return price; }
    public void setPrice (double price) { this.price = price; }

    public String getCategory () { return category;  }
    public void setCategory (String category) { this.category = category; }
}//1
