package ua.lviv.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.shop.service.BasketService;

import java.security.Principal;

/**
 * Created by Apple on 12.04.2017.
 */
@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @RequestMapping(value = "/addToBasket/{id}")
    public String addToBasket(@PathVariable Integer id, Principal principal) {
        basketService.add(id, principal);
        return "redirect:/";
    }

    @RequestMapping(value = "/userBasket")
    public String getUserBasket(Principal principal, Model model) {
        model.addAttribute("commodities", basketService.getUserCommoditiesInBasket(principal, model));
        model.addAttribute("SUM", basketService.calculateSum(basketService.getUserCommoditiesInBasket(principal, model)));
        return "commodityInBasket";
    }

    @RequestMapping(value = "/deleteCommodityFromBasket/{id}")
    public String deleteCommodityFromBasket(@PathVariable Integer id) {
        basketService.deleteCommodityFromBasket(id);
        return "redirect:/userBasket";
    }

}
