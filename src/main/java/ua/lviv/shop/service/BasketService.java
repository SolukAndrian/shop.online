package ua.lviv.shop.service;

import org.springframework.ui.Model;
import ua.lviv.shop.entity.Basket;
import ua.lviv.shop.entity.Commodity;

import java.security.Principal;
import java.util.List;

public interface BasketService {
    void add(Integer id, Principal principal);
    void delete(int id);
    Basket findById(int id);
    List<Basket> basketsUser(int id);
    List<Basket> findAll();
    Double calculateSum(List<Commodity> commodities);
    List<Commodity> getUserCommoditiesInBasket(Principal principal, Model model);
    void deleteCommodityFromBasket(int id);
}
