package ua.lviv.sombra.service;

import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.Commodity;

import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
public interface BasketService {
    void add(Basket busket);
    void delete(int id);
    Basket findById(int id);
    List<Basket> basketUser(int id);
    List<Basket> findAll();
    void setNullCommodity(int id,Commodity commodity);
}
