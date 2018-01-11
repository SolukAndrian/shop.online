package ua.lviv.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.Commodity;

import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    @Query(value = "select n from Commodity n where n.name like :fieldForSearch% or n.brand like :fieldForSearch%")
    List<Commodity> findAllByNameOrBrand(@Param("fieldForSearch") String fieldForSearch);

    @Query(value = "select c from Commodity c where c.categoryId.id=:id")
    List<Commodity> findAllByCategoryId(@Param("id") Integer id);
}
