package ua.lviv.sombra.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.sombra.dao.CustomerDao;
import ua.lviv.sombra.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Apple on 05.04.2017.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext(name = "sombra")
    EntityManager entityManager;

    @Transactional
    public void add(Customer customer) {
        entityManager.persist(customer);
    }
    @Transactional
    public void edit(Customer customer) {
        entityManager.merge(customer);
    }
    @Transactional
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }
    @Transactional
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }
    @Transactional
    public Customer findByLogin(String login) {
        return (Customer)entityManager.createQuery("select c from Customer c where c.login=:login").setParameter("login",login).getSingleResult();
    }


}
