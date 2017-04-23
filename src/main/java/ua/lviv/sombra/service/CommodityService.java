package ua.lviv.sombra.service;

import org.springframework.stereotype.Service;
import ua.lviv.sombra.entity.Category;
import ua.lviv.sombra.entity.Commodity;

import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
public interface CommodityService {
    void add(Commodity commodity);
    void edit(int id,String name, double price, String brand, String description,byte[] image, Category category);
    void edit2(int id,String name, double price, String brand, String description,byte[] image,Category category);

    void delete(int id);
    Commodity findById(int id);
    List<Commodity> findAll();
    List<Commodity> findByNameBrand(String name);
    List<Commodity> findByCategory(int id);
    void setNullCategory(int id, Category category);
}
