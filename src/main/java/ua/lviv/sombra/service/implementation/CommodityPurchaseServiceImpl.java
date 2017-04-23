package ua.lviv.sombra.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.sombra.dao.CommodityPurchaseDao;
import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.entity.CommodityPurchase;
import ua.lviv.sombra.entity.Purchase;
import ua.lviv.sombra.service.CommodityPurchaseService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 21.04.2017.
 */
@Service
public class CommodityPurchaseServiceImpl implements CommodityPurchaseService {
    @Autowired
    CommodityPurchaseDao commodityPurchaseDao;

    public void add(CommodityPurchase commodityPurchase) {
        commodityPurchaseDao.add(commodityPurchase);
    }

    public void edit(int id, Commodity commodityId, Purchase purchaseId) {
        CommodityPurchase commodityPurchase = commodityPurchaseDao.findById(id);
        if(commodityId!=null){
            commodityPurchase.setCommodityId(commodityId);
        }
        if(purchaseId!=null){
            commodityPurchase.setPurchaseId(purchaseId);
        }
        commodityPurchaseDao.edit(commodityPurchase);
    }

    public void setNullCommodity(int id, Commodity commodityId) {
        CommodityPurchase commodityPurchase = commodityPurchaseDao.findById(id);
        commodityPurchase.setCommodityId(null);
        commodityPurchaseDao.edit(commodityPurchase);
    }

    @Transactional
    public void delete(int id) {
        commodityPurchaseDao.delete(commodityPurchaseDao.findById(id));
    }

    public CommodityPurchase findById(int id) {
        return commodityPurchaseDao.findById(id);
    }

    public List<CommodityPurchase> findAll() {
        return commodityPurchaseDao.findAll();
    }
}
