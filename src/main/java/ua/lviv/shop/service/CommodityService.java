package ua.lviv.shop.service;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.shop.entity.Commodity;

import java.io.IOException;
import java.util.List;


public interface CommodityService {
    void add(String name, String brand, Double price, String description, MultipartFile image, Integer categoryId) throws IOException;
    void edit(int id, String name, double price, String brand, String description, MultipartFile image, Integer categoryId) throws IOException;
    void delete(int id);
    Commodity findById(int id);
    List<Commodity> findAll();
    List<Commodity> findByNameAndBrand(String fieldForSearch);
    List<Commodity> findByCategory(Integer id);
}
