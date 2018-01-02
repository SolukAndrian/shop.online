package ua.lviv.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.shop.service.PurchaseService;

import java.security.Principal;

/**
 * Created by Apple on 21.04.2017.
 */
@Controller
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(value = "/acceptPage", method = RequestMethod.GET)
    public String getAcceptPurchasePage() {
        return "acceptPurchase";
    }

    @RequestMapping(value = "/buyAll")
    public String buyAll(Principal principal) {
        purchaseService.buyAll(principal);
        return "redirect:/acceptPage";
    }
}
