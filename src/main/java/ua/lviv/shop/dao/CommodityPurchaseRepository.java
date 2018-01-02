package ua.lviv.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.shop.entity.CommodityPurchase;

/**
 * Created by Apple on 21.04.2017.
 */
public interface CommodityPurchaseRepository extends JpaRepository<CommodityPurchase, Integer> {
}
