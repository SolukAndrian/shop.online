package ua.lviv.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.shop.entity.Customer;

/**
 * Created by Apple on 05.04.2017.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findOneByLogin(String login);

}
