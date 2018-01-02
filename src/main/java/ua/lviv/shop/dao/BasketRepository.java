package ua.lviv.shop.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.lviv.shop.entity.Basket;

import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
public interface BasketRepository extends JpaRepository<Basket, Integer> {
    @Query(value = "select c from Basket c where c.customerId.id=:id")
    List<Basket> basketsUser(@Param("id") int id);
}
