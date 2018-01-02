package ua.lviv.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.shop.entity.Category;

/**
 * Created by Apple on 10.04.2017.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
