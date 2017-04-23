package ua.lviv.sombra.service;

import ua.lviv.sombra.entity.Category;
import ua.lviv.sombra.entity.Customer;

import java.util.List;

/**
 * Created by Apple on 10.04.2017.
 */
public interface CategoryService {
    void add(Category category);
    void edit(int id,String name);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
