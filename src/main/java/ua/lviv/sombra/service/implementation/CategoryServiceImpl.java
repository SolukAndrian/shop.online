package ua.lviv.sombra.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.sombra.dao.CategoryDao;
import ua.lviv.sombra.entity.Category;
import ua.lviv.sombra.entity.Customer;
import ua.lviv.sombra.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 10.04.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public void add(Category category) {
        categoryDao.add(category);
    }

    public void edit(int id, String name) {
        Category category = categoryDao.findById(id);
        if(name!="" && !name.equals(""))
        {
            category.setName(name);
        }
        categoryDao.edit(category);
    }

    @Transactional
    public void delete(int id) {
        categoryDao.delete(categoryDao.findById(id));
    }

    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
