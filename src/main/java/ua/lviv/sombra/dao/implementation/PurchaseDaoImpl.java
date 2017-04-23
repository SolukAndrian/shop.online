package ua.lviv.sombra.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.sombra.dao.PurchaseDao;
import ua.lviv.sombra.entity.Purchase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Apple on 22.04.2017.
 */
@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    @PersistenceContext(name = "sombra")
    EntityManager entityManager;

    @Transactional
    public void add(Purchase purchase) {
        entityManager.persist(purchase);
    }

    @Transactional
    public void edit(Purchase purchase) {
        entityManager.merge(purchase);
    }

    @Transactional
    public void delete(Purchase purchase) {
        entityManager.remove(purchase);
    }

    @Transactional
    public Purchase findById(int id) {
        return entityManager.find(Purchase.class,id);
    }
}
