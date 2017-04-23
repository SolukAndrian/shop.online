package ua.lviv.sombra.service;

import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.entity.CommodityPurchase;
import ua.lviv.sombra.entity.Purchase;

import java.util.List;

/**
 * Created by Apple on 21.04.2017.
 */
public interface CommodityPurchaseService {
    void add(CommodityPurchase commodityPurchase);
    void edit(int id, Commodity commodityId, Purchase purchaseId);
    void setNullCommodity(int id, Commodity commodityId);
    void delete(int id);
    CommodityPurchase findById(int id);
    List<CommodityPurchase> findAll();
}
