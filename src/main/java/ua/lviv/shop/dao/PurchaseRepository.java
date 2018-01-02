package ua.lviv.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.shop.entity.Purchase;

/**
 * Created by Apple on 22.04.2017.
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
