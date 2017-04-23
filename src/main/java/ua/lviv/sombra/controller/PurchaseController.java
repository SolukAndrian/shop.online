package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.CommodityPurchase;
import ua.lviv.sombra.entity.Customer;
import ua.lviv.sombra.entity.Purchase;
import ua.lviv.sombra.service.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Apple on 21.04.2017.
 */
@Controller
public class PurchaseController {
    @Autowired
    CommodityPurchaseService commodityPurchaseService;

    @Autowired
    BasketService basketService;

    @Autowired
    CommodityService commodityService;

    @Autowired
    CustomerService customerService;

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(value = "/acceptPage", method = RequestMethod.GET)
    public String acceptPurchasePage(){
        return "acceptPurchase";
    }

    @RequestMapping(value = "/buyAll")
    public String buyAll(Principal principal){
        Customer customer = customerService.findByLogin(principal.getName());
        List<Basket> basketList=basketService.basketUser(customer.getId());
        CommodityPurchase commodityPurchase;
        double sum=0;
        for(Basket b : basketList){
            sum+=b.getIdCommodity().getPrice();
        }
        Purchase purchase = new Purchase(sum,null,customer);
        purchaseService.add(purchase);
        for(Basket b : basketList){
            if(b.getIdCustomer().getId()==customer.getId()){
                commodityPurchase= new CommodityPurchase(b.getIdCommodity(),purchase);
                commodityPurchaseService.add(commodityPurchase);
            }
        }

        List<Basket> basketList2 = basketService.basketUser(customer.getId());
        for(Basket b : basketList2){
            basketService.delete(b.getId());
        }
        return "redirect:/acceptPage";
    }
}
