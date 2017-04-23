package ua.lviv.sombra.entity;

import javax.persistence.*;

/**
 * Created by Apple on 10.04.2017.
 */
@Entity
public class CommodityPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public CommodityPurchase() {
    }

    public CommodityPurchase(Commodity commodityId, Purchase purchaseId) {
        this.commodityId = commodityId;
        this.purchaseId = purchaseId;
    }

    @ManyToOne
    private Commodity commodityId;
    @ManyToOne
    private Purchase purchaseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commodity getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Commodity commodityId) {
        this.commodityId = commodityId;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }
}
