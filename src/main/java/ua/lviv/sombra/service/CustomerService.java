package ua.lviv.sombra.service;

import org.springframework.stereotype.Service;
import ua.lviv.sombra.entity.Customer;

/**
 * Created by Apple on 05.04.2017.
 */
public interface CustomerService {
    void add(Customer customer);
    void edit(int id,String surname, String name, String address, String phone, String email, String login, String password);
    void delete(int id);
    Customer findById(int id);
    Customer findByLogin(String login);
}
