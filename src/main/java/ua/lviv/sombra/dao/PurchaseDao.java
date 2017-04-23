package ua.lviv.sombra.dao;

import ua.lviv.sombra.entity.Purchase;

/**
 * Created by Apple on 22.04.2017.
 */
public interface PurchaseDao {
    void add(Purchase purchase);
    void edit(Purchase purchase);
    void delete(Purchase purchase);
    Purchase findById(int id);
}
