package ua.lviv.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ua.lviv.shop.repository.BasketRepository;
import ua.lviv.shop.entity.Basket;
import ua.lviv.shop.entity.Commodity;
import ua.lviv.shop.entity.Customer;
import ua.lviv.shop.service.BasketService;
import ua.lviv.shop.service.CommodityService;
import ua.lviv.shop.service.CustomerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 12.04.2017.
 */
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    CustomerService customerService;
    @Autowired
    CommodityService commodityService;

    public void add(Integer id, String login) {
        Customer customer = customerService.findByLogin(login);
        Commodity commodity = commodityService.findById(id);
        Basket basket = new Basket(customer,commodity);
        basketRepository.save(basket);
    }

    @Transactional
    public void delete(int id) {
        basketRepository.delete(basketRepository.findOne(id));
    }

    @Transactional
    public Basket findById(int id) {
        return basketRepository.findOne(id);
    }

    public List<Basket> basketsUser(int id) {
        return basketRepository.basketsUser(id);
    }

    public List<Basket> findAll() {
        return basketRepository.findAll();
    }

    public Double calculateSum(List<Commodity> commodities) {
        double sum=0;
        for(Commodity commodity : commodities){
            sum+=commodity.getPrice();
        }
        return sum;
    }

    public List<Commodity> getUserCommoditiesInBasket(String login) {
        Customer customer = customerService.findByLogin(login);
        List<Basket> basketList=basketsUser(customer.getId());
        List<Commodity> commodityList = new ArrayList<Commodity>();
        for(Basket basket : basketList){
            commodityList.add(basket.getIdCommodity());
        }
        return commodityList;
    }

    public void deleteCommodityFromBasket(int id) {
        List<Basket> basketList = findAll();
        int basketId=0;

        for(Basket basket : basketList){
            if(basket.getIdCommodity().getId()==id){
                basketId=basket.getId();
            }
        }
        delete(basketId);
    }
}
