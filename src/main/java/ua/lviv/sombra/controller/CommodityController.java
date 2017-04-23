package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.Category;
import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.entity.CommodityPurchase;
import ua.lviv.sombra.service.BasketService;
import ua.lviv.sombra.service.CategoryService;
import ua.lviv.sombra.service.CommodityPurchaseService;
import ua.lviv.sombra.service.CommodityService;

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

    @Autowired
    CommodityPurchaseService commodityPurchaseService;

    @Autowired
    BasketService basketService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage(Model model){
        List<Commodity> commodityList = commodityService.findAll();
        model.addAttribute("commodities", commodityList);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        return "home";
    }

    @RequestMapping(value = "/commodityAdd", method = RequestMethod.GET)
    public String addCommodity(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        return "commodityAdd";
    }
    @RequestMapping(value = "/commodityAdd", method = RequestMethod.POST)
    public String addCommodity(@RequestParam("name") String name,
                               @RequestParam("brand") String brand,
                               @RequestParam("price") Double price,
                               @RequestParam("description") String description,
                               @RequestParam(value = "image") MultipartFile image,

                               @RequestParam(value = "category") Integer categoryId

                               ) throws IOException
    {
        System.out.println(categoryId);
        byte[] image1=image.getBytes();
        if(categoryId!=-1){
            Category category=categoryService.findById(categoryId);
            Commodity commodity = new Commodity(name,price,brand,description,image1,category);
            commodityService.add(commodity);
        }
        else if(categoryId==-1){
            Commodity commodity = new Commodity(name,price,brand,description,image1);
            commodityService.add(commodity);

        }

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
    public String editCommodity(@PathVariable Integer id, Model model){
        Commodity commodity = commodityService.findById(id);
        model.addAttribute("com",commodity);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        return "commodityEdit";
    }

    @RequestMapping(value = "/editCommodity", method = RequestMethod.POST)
    public String deleteCommodity(@RequestParam Integer id,
                                  @RequestParam String name,
                                  @RequestParam String brand,
                                  @RequestParam Double price,
                                  @RequestParam String description,
                                  @RequestParam(value = "image") MultipartFile image,
                                  @RequestParam(value = "category") Integer categoryId)throws IOException{
        byte[] imageByte=image.getBytes();
        if(categoryId==-1) {
            commodityService.edit(id, name, price, brand, description, imageByte,null);
        }
        else if(categoryId!=-1){
            Category category=categoryService.findById(categoryId);
            commodityService.edit2(id, name, price, brand, description, imageByte,category);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteCommodity/{id}")
    public String deleteCommodity(@PathVariable Integer id) throws NullPointerException{
        List<CommodityPurchase> commodityPurchases = commodityPurchaseService.findAll();
        Commodity commodity = commodityService.findById(id);
        for(CommodityPurchase c : commodityPurchases){
            if(c.getCommodityId()!=null){
                if(c.getCommodityId().getId()==commodity.getId()){
                    commodityPurchaseService.setNullCommodity(c.getId(),null);
                }
            }
        }
        List<Basket> basketList = basketService.findAll();
        for(Basket b : basketList){
            if(b.getIdCommodity()!=null){
                if(b.getIdCommodity().getId()==commodity.getId()){
                    basketService.delete(b.getId());
                }
            }
        }
        commodityService.delete(id);
        return "redirect:/";
    }


    @RequestMapping(value = "/searchCommodity", method = RequestMethod.GET)
    public String searchCommodity(){
        return "searchCommodity";
    }

    @RequestMapping(value = "/searchCommodity", method = RequestMethod.POST)
    public String searchCommodity(@RequestParam("search") String name,Model model){
        List<Commodity>commodityList=commodityService.findByNameBrand(name);
        model.addAttribute("commodityS", commodityList);
        return "searchCommodity";
    }


    @RequestMapping(value = "/commodity/{id}", method = RequestMethod.GET)
    public String commodityPage(@PathVariable Integer id, Model model){
        Commodity commodity = commodityService.findById(id);
        model.addAttribute("commodity",commodity);
        return "commodityPage";
    }

    @RequestMapping(value = "/commodityCategory/{id}", method = RequestMethod.GET)
    public String findByCategory(@PathVariable Integer id, Model model){
        List<Commodity> commodityList=commodityService.findByCategory(id);
        model.addAttribute("commodityCategory", commodityList);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        return "searchByCategory";
    }
}
