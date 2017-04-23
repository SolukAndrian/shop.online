package ua.lviv.sombra.service;

import ua.lviv.sombra.entity.Purchase;

/**
 * Created by Apple on 22.04.2017.
 */
public interface PurchaseService {
    void add(Purchase purchase);
    void edit(int id,double amount);
    void delete(int id);
    Purchase findById(int id);
}
