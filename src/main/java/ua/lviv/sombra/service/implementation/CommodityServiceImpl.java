package ua.lviv.sombra.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.sombra.dao.CommodityDao;
import ua.lviv.sombra.entity.Category;
import ua.lviv.sombra.entity.Commodity;
import ua.lviv.sombra.service.CommodityService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    CommodityDao commodityDao;

    public void add(Commodity commodity) {
        commodityDao.add(commodity);
    }

    public void edit(int id, String name, double price, String brand, String description,byte[] image,Category category) {
        Commodity commodity = commodityDao.findById(id);
        if(name!=null && !name.equals("")){
            commodity.setName(name);
        }
        if(price!=0){
            commodity.setPrice(price);
        }
        if(brand!=null && !brand.equals("")){
            commodity.setBrand(brand);
        }
        if(description!=null && !description.equals("")){
            commodity.setDescription(description);
        }
        if(image.length != 0 || image.equals("") || image != null){
            commodity.setImage(image);
        }

        commodity.setCategory(null);
        commodityDao.edit(commodity);
    }

    public void edit2(int id, String name, double price, String brand, String description, byte[] image, Category category) {
        Commodity commodity = commodityDao.findById(id);
        if(name!=null && !name.equals("")){
            commodity.setName(name);
        }
        if(price!=0){
            commodity.setPrice(price);
        }
        if(brand!=null && !brand.equals("")){
            commodity.setBrand(brand);
        }
        if(description!=null && !description.equals("")){
            commodity.setDescription(description);
        }
        if(image.length != 0 || image.equals("") || image != null){
            commodity.setImage(image);
        }
        if(category!=null){
            commodity.setCategory(category);
        }
        commodityDao.edit(commodity);
    }

    @Transactional
    public void delete(int id) {
        commodityDao.delete(commodityDao.findById(id));
    }

    public Commodity findById(int id) {
        return commodityDao.findById(id);
    }

    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }


    public List<Commodity> findByNameBrand(String name) {
        return commodityDao.findByNameBrand(name);
    }

    public List<Commodity> findByCategory(int id) {
        return commodityDao.findByCategory(id);
    }

    public void setNullCategory(int id, Category category) {
        Commodity commodity = commodityDao.findById(id);
        commodity.setCategory(null);
        commodityDao.edit(commodity);
    }
}
