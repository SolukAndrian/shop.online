package ua.lviv.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.dao.CategoryRepository;
import ua.lviv.shop.entity.Category;
import ua.lviv.shop.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 10.04.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void add(Category category) {
        categoryRepository.save(category);
    }

    public void edit(int id, String name) {
        Category category = categoryRepository.findOne(id);
        if(name!="" && !name.equals(""))
        {
            category.setName(name);
        }
        categoryRepository.save(category);
    }

    @Transactional
    public void delete(int id) {
        categoryRepository.delete(categoryRepository.findOne(id));
    }

    public Category findById(int id) {
        return categoryRepository.findOne(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
