package ua.lviv.sombra.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.sombra.dao.BasketDao;
import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.Commodity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
@Repository
public class BasketDaoImpl implements BasketDao {

    @PersistenceContext(name = "sombra")
    private EntityManager entityManager;

    @Transactional
    public void add(Basket basket) {
        entityManager.persist(basket);
    }

    @Transactional
    public void edit(Basket basket){entityManager.merge(basket);}

    @Transactional
    public void delete(Basket basket) {
        entityManager.remove(basket);
    }

    @Transactional
    public Basket findById(int id) {
        return entityManager.find(Basket.class,id);
    }

    @Transactional
    public List<Basket> basketUser(int id) {
        return entityManager.createQuery("select c from Basket c where c.idCustomer.id=:id").setParameter("id",id).getResultList();
    }

    @Transactional
    public List<Basket> findAll(){
        return entityManager.createQuery("select c from Basket c").getResultList();
    }
}
