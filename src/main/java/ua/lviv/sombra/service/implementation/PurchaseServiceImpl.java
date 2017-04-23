package ua.lviv.sombra.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.sombra.dao.PurchaseDao;
import ua.lviv.sombra.entity.Purchase;
import ua.lviv.sombra.service.PurchaseService;

import javax.transaction.Transactional;

/**
 * Created by Apple on 22.04.2017.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseDao purchaseDao;

    public void add(Purchase purchase) {
        purchaseDao.add(purchase);
    }

    public void edit(int id, double amount) {
        Purchase purchase = purchaseDao.findById(id);
        if(amount!=0){
            purchase.setAmount(amount);
        }
        purchaseDao.edit(purchase);
    }

    @Transactional
    public void delete(int id) {
        purchaseDao.delete(purchaseDao.findById(id));
    }

    public Purchase findById(int id) {
        return purchaseDao.findById(id);
    }
}
