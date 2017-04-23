package ua.lviv.sombra.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.sombra.dao.CategoryDao;
import ua.lviv.sombra.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 10.04.2017.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @PersistenceContext(name = "sombra")
    private EntityManager entityManager;

    @Transactional
    public void add(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    public void edit(Category category) {
        entityManager.merge(category);
    }

    @Transactional
    public void delete(Category category) {
        entityManager.remove(category);
    }

    @Transactional
    public Category findById(int id) {
        return entityManager.find(Category.class,id);
    }

    @Transactional
    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }
}
