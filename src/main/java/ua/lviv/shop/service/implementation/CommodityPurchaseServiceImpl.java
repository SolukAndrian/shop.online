package ua.lviv.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.repository.CommodityPurchaseRepository;
import ua.lviv.shop.entity.CommodityPurchase;
import ua.lviv.shop.service.CommodityPurchaseService;

/**
 * Created by Apple on 21.04.2017.
 */
@Service
public class CommodityPurchaseServiceImpl implements CommodityPurchaseService {
    @Autowired
    CommodityPurchaseRepository commodityPurchaseRepository;

    public void add(CommodityPurchase commodityPurchase) {
        commodityPurchaseRepository.save(commodityPurchase);
    }

}
