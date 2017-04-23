package ua.lviv.sombra.dao;

import ua.lviv.sombra.entity.CommodityPurchase;

import java.util.List;

/**
 * Created by Apple on 21.04.2017.
 */
public interface CommodityPurchaseDao {
    void add(CommodityPurchase commodityPurchase);
    void edit(CommodityPurchase commodityPurchase);
    void delete(CommodityPurchase commodityPurchase);
    CommodityPurchase findById(int id);
    List<CommodityPurchase> findAll();
}
