package ua.lviv.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.shop.repository.CommodityRepository;
import ua.lviv.shop.entity.Category;
import ua.lviv.shop.entity.Commodity;
import ua.lviv.shop.service.CategoryService;
import ua.lviv.shop.service.CommodityService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    CommodityRepository commodityRepository;
    @Autowired
    CategoryService categoryService;

    public void add(String name, String brand, Double price, String description, MultipartFile image, Integer categoryId) throws IOException {
        byte[] image1 = image.getBytes();
        if (categoryId != -1) {
            Category category = categoryService.findById(categoryId);
            Commodity commodity = new Commodity(name, price, brand, description, image1, category);
            commodityRepository.save(commodity);
        } else if (categoryId == -1) {
            Commodity commodity = new Commodity(name, price, brand, description, image1);
            commodityRepository.save(commodity);
        }
    }

    public void editWithoutCategory(int id, String name, double price, String brand, String description, byte[] image) {
        Commodity commodity = commodityRepository.findOne(id);
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

        commodity.setCategoryId(null);
        commodityRepository.save(commodity);
    }

    public void editWithCategory(int id, String name, double price, String brand, String description, byte[] image, Category category) {
        Commodity commodity = commodityRepository.findOne(id);
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
            commodity.setCategoryId(category);
        }
        commodityRepository.save(commodity);
    }

    public void edit(int id, String name, double price, String brand, String description, MultipartFile image, Integer categoryId) throws IOException {
        byte[] imageByte = image.getBytes();
        if (categoryId == -1) {
            editWithoutCategory(id, name, price, brand, description, imageByte);
        } else if (categoryId != -1) {
            Category category = categoryService.findById(categoryId);
            editWithCategory(id, name, price, brand, description, imageByte, category);
        }
    }

    @Transactional
    public void delete(int id) {
        commodityRepository.delete(commodityRepository.findOne(id));
    }

    public Commodity findById(int id) {
        return commodityRepository.findOne(id);
    }

    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }


    public List<Commodity> findByNameAndBrand(String fieldForSearch) {
        return commodityRepository.findAllByNameOrBrand(fieldForSearch);
    }

    public List<Commodity> findByCategory(Integer id) {
        return commodityRepository.findAllByCategoryId(id);
    }

}
