package ua.lviv.shop.dto;

/**
 * Created by Apple on 19.04.2017.
 */
public class CategoryDto {
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
