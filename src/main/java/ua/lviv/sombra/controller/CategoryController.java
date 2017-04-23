package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lviv.sombra.dao.CategoryDao;
import ua.lviv.sombra.dto.CategoryDto;
import ua.lviv.sombra.entity.Category;
import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.service.CategoryService;
import ua.lviv.sombra.service.CommodityService;

import java.util.List;

/**
 * Created by Apple on 10.04.2017.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CommodityService commodityService;

    @RequestMapping(value = "/categoryAdd", method = RequestMethod.GET)
    public String categoryPage(){
        return "categoryAdd";
    }
    @RequestMapping(value = "/categoryAdd", method = RequestMethod.POST)
    public void categoryPage(@RequestBody CategoryDto categoryDto){
        Category category = new Category(categoryDto.getName());
        categoryService.add(category);
    }

    @RequestMapping(value = "/deleteCategory/{id}")
    public String deleteDeparture(@PathVariable Integer id)throws NullPointerException{
        List<Commodity> commodityList = commodityService.findAll();
        Category category = categoryService.findById(id);
        for(Commodity c : commodityList){
            if(c.getCategory()!=null){
                if(c.getCategory().getId()==category.getId()){
                    commodityService.setNullCategory(c.getId(),null);
                }
            }
        }
        categoryService.delete(id);
        return "redirect:/";
    }
}
