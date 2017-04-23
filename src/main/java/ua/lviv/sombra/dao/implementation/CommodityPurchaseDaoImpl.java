package ua.lviv.sombra.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.sombra.dao.CommodityPurchaseDao;
import ua.lviv.sombra.entity.CommodityPurchase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 21.04.2017.
 */
@Repository
public class CommodityPurchaseDaoImpl implements CommodityPurchaseDao {

    @PersistenceContext(name = "sombra")
    private EntityManager entityManager;

    @Transactional
    public void add(CommodityPurchase commodityPurchase) {
        entityManager.persist(commodityPurchase);
    }

    @Transactional
    public void edit(CommodityPurchase commodityPurchase) {
        entityManager.merge(commodityPurchase);
    }

    @Transactional
    public void delete(CommodityPurchase commodityPurchase) {
        entityManager.remove(commodityPurchase);
    }

    @Transactional
    public CommodityPurchase findById(int id) {
        return entityManager.find(CommodityPurchase.class,id);
    }

    @Transactional
    public List<CommodityPurchase> findAll() {
        return entityManager.createQuery("select c from CommodityPurchase c").getResultList();
    }
}
