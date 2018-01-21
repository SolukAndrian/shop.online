package ua.lviv.shop.service;

import org.springframework.ui.Model;
import ua.lviv.shop.entity.Basket;
import ua.lviv.shop.entity.Commodity;

import java.security.Principal;
import java.util.List;

public interface BasketService {
    void add(Integer id, String login);
    void delete(int id);
    Basket findById(int id);
    List<Basket> basketsUser(int id);
    List<Basket> findAll();
    Double calculateSum(List<Commodity> commodities);
    List<Commodity> getUserCommoditiesInBasket(String login);
    void deleteCommodityFromBasket(int id);
}
