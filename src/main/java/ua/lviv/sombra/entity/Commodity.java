package ua.lviv.sombra.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String description;
    @Lob()
    private byte [] image;

    @OneToMany(mappedBy = "commodityId")
    private List<CommodityPurchase> commodityPurchaseList;

    @OneToMany(mappedBy = "idCommodity")
    List<Basket> basketList;

    @ManyToOne
    private Category category;

    public Commodity() {
    }

    public Commodity(String name, double price, String brand, String description, byte[] image) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.image = image;
    }

    public Commodity(String name, double price, String brand, String description, byte[] image, Category category) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
