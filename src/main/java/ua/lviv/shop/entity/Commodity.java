package ua.lviv.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String description;
    @Lob()
    private byte [] image;

    @OneToMany(mappedBy = "commodityId", cascade = CascadeType.ALL)
    private List<CommodityPurchase> commodityPurchaseList;

    @OneToMany(mappedBy = "idCommodity")
    private List<Basket> basketList;

    @ManyToOne
    private Category categoryId;

    public Commodity() {
    }

    public Commodity(String name, Double price, String brand, String description, byte[] image) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.image = image;
    }

    public Commodity(String name, Double price, String brand, String description, byte[] image, Category categoryId) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommodityPurchase> getCommodityPurchaseList() {
        return commodityPurchaseList;
    }

    public void setCommodityPurchaseList(List<CommodityPurchase> commodityPurchaseList) {
        this.commodityPurchaseList = commodityPurchaseList;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category category) {
        this.categoryId = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Basket> getBasketList() {
        return basketList;
    }

    public void setBasketList(List<Basket> basketList) {
        this.basketList = basketList;
    }
}
