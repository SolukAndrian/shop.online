package ua.lviv.sombra.dao;

import ua.lviv.sombra.entity.Commodity;

import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
public interface CommodityDao {
    void add(Commodity commodity);
    void edit(Commodity commodity);
    void delete(Commodity commodity);
    Commodity findById(int id);
    List<Commodity> findAll();
    List<Commodity> findByNameBrand(String name);
    List<Commodity> findByCategory(int id);
}
