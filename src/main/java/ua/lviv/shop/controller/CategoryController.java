package ua.lviv.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.shop.dto.CategoryDto;
import ua.lviv.shop.entity.Category;
import ua.lviv.shop.service.CategoryService;

/**
 * Created by Apple on 10.04.2017.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/categoryAdd", method = RequestMethod.GET)
    public String getPageForAddingCategory() {
        return "categoryAdd";
    }

    @RequestMapping(value = "/categoryAdd", method = RequestMethod.POST)
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getName());
        categoryService.add(category);
    }

    @RequestMapping(value = "/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Integer id) throws NullPointerException {
        categoryService.delete(id);
        return "redirect:/";
    }
}
