package ru.gb.antonov.j75.dtos;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static ru.gb.antonov.j75.dtos.Factory.PRODCAT_NAMELEN_MAX;
import static ru.gb.antonov.j75.dtos.Factory.PRODCAT_NAMELEN_MIN;

//@Data  < в общем модуле (и в дюбом модуле многомодульного проекта, на который кто-то ссылается
//         следует избегать автогенерации кода при пом ломбока и ему подобных утилит.)
@NoArgsConstructor
public class ProductCategoryDto
{
    private Long id;

    @NotNull (message="Не указано название категории товара!")
    @Length (min= PRODCAT_NAMELEN_MIN,
             max= PRODCAT_NAMELEN_MAX,
             message="Длина названия категории товара: 1…255 символов!")
    private String           name;
//-------------- Геттеры и сеттеры -----------------------------
    public Long getId () { return id; }
    public void setId (Long id) { this.id = id; }

    public String getName () { return name; }
    public void setName (String name) { this.name = name; }
}//1
