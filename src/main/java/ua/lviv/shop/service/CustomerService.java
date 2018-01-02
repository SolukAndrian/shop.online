package ua.lviv.shop.service;

import ua.lviv.shop.entity.Customer;


public interface CustomerService {
    void add(Customer customer);
    void edit(int id,String surname, String name, String address, String phone, String email, String login, String password);
    void delete(int id);
    Customer findById(int id);
    Customer findByLogin(String login);
}
