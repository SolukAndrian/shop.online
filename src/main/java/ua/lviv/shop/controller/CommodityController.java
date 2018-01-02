package ua.lviv.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.shop.entity.Category;
import ua.lviv.shop.entity.Commodity;
import ua.lviv.shop.service.CategoryService;
import ua.lviv.shop.service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Controller
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute("commodities", commodityService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @RequestMapping(value = "/commodityAdd", method = RequestMethod.GET)
    public String getPageForAddingCommodity(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "commodityAdd";
    }

    @RequestMapping(value = "/commodityAdd", method = RequestMethod.POST)
    public String addCommodity(@RequestParam("name") String name,
                               @RequestParam("brand") String brand,
                               @RequestParam("price") Double price,
                               @RequestParam("description") String description,
                               @RequestParam(value = "image") MultipartFile image,
                               @RequestParam(value = "category") Integer categoryId) throws IOException {
        commodityService.add(name, brand, price, description, image, categoryId);
        return "redirect:/";
    }

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam(value = "id") Integer id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        Commodity commodity = commodityService.findById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(commodity.getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/commodity/edit/{id}")
    public String getPageEditCommodity(@PathVariable Integer id, Model model) {
        model.addAttribute("com", commodityService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "commodityEdit";
    }

    @RequestMapping(value = "/editCommodity", method = RequestMethod.POST)
    public String editCommodity(@RequestParam Integer id,
                                @RequestParam String name,
                                @RequestParam String brand,
                                @RequestParam Double price,
                                @RequestParam String description,
                                @RequestParam(value = "image") MultipartFile image,
                                @RequestParam(value = "category") Integer categoryId) throws IOException {
        commodityService.edit(id, name, price, brand, description, image, categoryId);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteCommodity/{id}")
    public String deleteCommodity(@PathVariable Integer id) {
        commodityService.delete(id);
        return "redirect:/";
    }


    @RequestMapping(value = "/searchCommodity", method = RequestMethod.GET)
    public String getPageSearchCommodityByNameOrBrand() {
        return "searchCommodity";
    }

    @RequestMapping(value = "/searchCommodity", method = RequestMethod.POST)
    public String findByNameOrBrand(@RequestParam("search") String name, Model model) {
        model.addAttribute("commodityS", commodityService.findByNameAndBrand(name));
        return "searchCommodity";
    }


    @RequestMapping(value = "/commodity/{id}", method = RequestMethod.GET)
    public String getCommodityPage(@PathVariable Integer id, Model model) {
        model.addAttribute("commodity", commodityService.findById(id));
        return "commodityPage";
    }

    @RequestMapping(value = "/commodityCategory/{id}", method = RequestMethod.GET)
    public String findByCategory(@PathVariable Integer id, Model model) {
        List<Commodity> commodityList = commodityService.findByCategory(id);
        model.addAttribute("commodityCategory", commodityList);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        model.addAttribute("selectedcategory", id);
        return "searchByCategory";
    }
}
