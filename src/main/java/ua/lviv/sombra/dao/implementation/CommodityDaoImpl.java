package ua.lviv.sombra.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.sombra.dao.CommodityDao;
import ua.lviv.sombra.entity.Commodity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Repository
public class CommodityDaoImpl implements CommodityDao {

    @PersistenceContext(name = "sombra")
    private EntityManager entityManager;

    @Transactional
    public void add(Commodity commodity) {
        entityManager.persist(commodity);
    }

    @Transactional
    public void edit(Commodity commodity) {
        entityManager.merge(commodity);
    }

    @Transactional
    public void delete(Commodity commodity) {
        entityManager.remove(commodity);
    }

    @Transactional
    public Commodity findById(int id) {
        return entityManager.find(Commodity.class,id);
    }

    @Transactional
    public List<Commodity> findAll() {
        return entityManager.createQuery("select c From Commodity c").getResultList();
    }

    @Transactional
    public List<Commodity> findByNameBrand(String name) {
        return entityManager.createQuery("select n from Commodity n where n.name like :name or n.brand like :name").setParameter("name",name+"%").getResultList();
    }

    public List<Commodity> findByCategory(int id) {
        return entityManager.createQuery("select c from Commodity c where c.category.id=:id").setParameter("id",id).getResultList();
    }
}
