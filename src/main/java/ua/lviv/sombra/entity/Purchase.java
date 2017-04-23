package ua.lviv.sombra.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Apple on 04.04.2017.
 */
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private double amount;
    @Column
    private Date date;

    public Purchase() {
    }

    public Purchase(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Purchase(double amount, Date date, Customer customer) {
        this.amount = amount;
        this.date = date;
        this.customer = customer;
    }

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "purchaseId")
    private List<CommodityPurchase> commodityPurchaseList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CommodityPurchase> getCommodityPurchaseList() {
        return commodityPurchaseList;
    }

    public void setCommodityPurchaseList(List<CommodityPurchase> commodityPurchaseList) {
        this.commodityPurchaseList = commodityPurchaseList;
    }
}
