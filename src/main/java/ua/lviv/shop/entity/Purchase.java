package ua.lviv.shop.entity;

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
    private Integer id;
    @Column
    private Double amount;
    @Column
    private Date date;

    @ManyToOne
    private Customer customerId;

    @OneToMany(mappedBy = "purchaseId")
    private List<CommodityPurchase> commodityPurchaseList;

    public Purchase() {
    }

    public Purchase(Double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Purchase(Double amount, Date date, Customer customerId) {
        this.amount = amount;
        this.date = date;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customer) {
        this.customerId = customer;
    }

    public List<CommodityPurchase> getCommodityPurchaseList() {
        return commodityPurchaseList;
    }

    public void setCommodityPurchaseList(List<CommodityPurchase> commodityPurchaseList) {
        this.commodityPurchaseList = commodityPurchaseList;
    }
}
