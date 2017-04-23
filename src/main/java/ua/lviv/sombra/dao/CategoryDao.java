package ua.lviv.sombra.dao;

import ua.lviv.sombra.entity.Category;

import java.util.List;

/**
 * Created by Apple on 10.04.2017.
 */
public interface CategoryDao {
    void add(Category category);
    void edit(Category category);
    void delete(Category category);
    Category findById(int id);
    List<Category> findAll();
}
