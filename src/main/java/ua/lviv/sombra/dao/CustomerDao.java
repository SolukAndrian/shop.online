package ua.lviv.sombra.dao;

import ua.lviv.sombra.entity.Customer;

/**
 * Created by Apple on 05.04.2017.
 */
public interface CustomerDao {
    void add(Customer customer);
    void edit(Customer customer);
    void delete(Customer customer);
    Customer findById(int id);
    Customer findByLogin(String login);

}
