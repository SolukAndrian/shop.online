package ua.lviv.shop.service;

import ua.lviv.shop.entity.Category;

import java.util.List;


public interface CategoryService {
    void add(Category category);
    void edit(int id,String name);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
