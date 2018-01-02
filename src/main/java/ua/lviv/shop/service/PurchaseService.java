package ua.lviv.shop.service;

import ua.lviv.shop.entity.Purchase;

import java.security.Principal;

public interface PurchaseService {
    void add(Purchase purchase);
    void edit(int id,double amount);
    void delete(int id);
    Purchase findById(int id);
    void buyAll(Principal principal);
}
