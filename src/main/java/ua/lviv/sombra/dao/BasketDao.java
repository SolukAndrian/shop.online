package ua.lviv.sombra.dao;

import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.Commodity;

import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
public interface BasketDao {
    void add(Basket basket);
    void edit(Basket basket);
    void delete(Basket basket);
    Basket findById(int id);
    List<Basket> basketUser(int id);
    List<Basket> findAll();
}
