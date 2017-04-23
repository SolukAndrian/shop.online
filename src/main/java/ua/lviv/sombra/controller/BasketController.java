package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.entity.Customer;
import ua.lviv.sombra.service.BasketService;
import ua.lviv.sombra.service.CommodityService;
import ua.lviv.sombra.service.CustomerService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CommodityService commodityService;

    @RequestMapping(value = "/addToBasket/{id}")
    public String addToBusket(@PathVariable Integer id, Principal principal){
        Customer customer = customerService.findByLogin(principal.getName());
        Commodity commodity = commodityService.findById(id);
        Basket basket = new Basket(customer,commodity);
        System.out.println(basket);
        basketService.add(basket);
        return "redirect:/";
    }

    @RequestMapping(value = "/userBasket")
    public String userBasket(Principal principal,Model model){
        Customer customer = customerService.findByLogin(principal.getName());
        List<Basket> basketList=basketService.basketUser(customer.getId());
        List<Commodity> commodityList = new ArrayList<Commodity>();
        for(Basket b : basketList){
            commodityList.add(b.getIdCommodity());
        }
        model.addAttribute("commodities",commodityList);


        double sum=0;
        for(Commodity commodity : commodityList){
            sum+=commodity.getPrice();
        }
        model.addAttribute("SUM",sum);
        return "commodityInBasket";
    }

    @RequestMapping(value = "/deleteCommodityFromBasket/{id}")
    public String deleteCommodityFromBasket(@PathVariable Integer id){//доробити видаляє не саме той продукт
        List<Basket> basketList = basketService.findAll();
        int qwe=0;

        for(Basket b : basketList){
            if(b.getIdCommodity().getId()==id){
                qwe=b.getId();
            }
        }
        basketService.delete(qwe);
        return "redirect:/userBasket";
    }

}
