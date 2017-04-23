package ua.lviv.sombra.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.sombra.dao.BasketDao;
import ua.lviv.sombra.entity.Basket;
import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.service.BasketService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketDao basketDao;

    public void add(Basket busket) {
        basketDao.add(busket);
    }

    @Transactional
    public void delete(int id) {
        basketDao.delete(basketDao.findById(id));
    }

    @Transactional
    public Basket findById(int id) {
        return basketDao.findById(id);
    }

    public List<Basket> basketUser(int id) {
        return basketDao.basketUser(id);
    }

    public List<Basket> findAll() {
        return basketDao.findAll();
    }

    public void setNullCommodity(int id, Commodity commodity) {
        Basket basket = basketDao.findById(id);
        basket.setIdCommodity(null);
        basketDao.edit(basket);
    }
}
