package ua.lviv.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.dao.PurchaseRepository;
import ua.lviv.shop.entity.Basket;
import ua.lviv.shop.entity.CommodityPurchase;
import ua.lviv.shop.entity.Customer;
import ua.lviv.shop.entity.Purchase;
import ua.lviv.shop.service.BasketService;
import ua.lviv.shop.service.CommodityPurchaseService;
import ua.lviv.shop.service.CustomerService;
import ua.lviv.shop.service.PurchaseService;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by Apple on 22.04.2017.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CommodityPurchaseService commodityPurchaseService;

    @Autowired
    BasketService basketService;

    @Autowired
    CustomerService customerService;

    public void add(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public void edit(int id, double amount) {
        Purchase purchase = purchaseRepository.findOne(id);
        if (amount != 0) {
            purchase.setAmount(amount);
        }
        purchaseRepository.save(purchase);
    }

    @Transactional
    public void delete(int id) {
        purchaseRepository.delete(purchaseRepository.findOne(id));
    }

    public Purchase findById(int id) {
        return purchaseRepository.findOne(id);
    }

    public void buyAll(Principal principal) {
        Customer customer = customerService.findByLogin(principal.getName());
        List<Basket> basketList = basketService.basketsUser(customer.getId());
        CommodityPurchase commodityPurchase;
        double sum = 0;
        for (Basket basket : basketList) {
            sum += basket.getIdCommodity().getPrice();
        }
        Purchase purchase = new Purchase(sum, new Date(), customer);
        add(purchase);

        for (Basket basket : basketList) {
            if (basket.getCustomerId().getId() == customer.getId()) {
                commodityPurchase = new CommodityPurchase(basket.getIdCommodity(), purchase);
                commodityPurchaseService.add(commodityPurchase);
            }
        }
        for (Basket b : basketService.basketsUser(customer.getId())) {
            basketService.delete(b.getId());
        }
    }
}
