package ua.lviv.shop.entity;

import javax.persistence.*;

/**
 * Created by Apple on 12.04.2017.
 */
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Customer customerId;
    @ManyToOne
    private Commodity idCommodity;

    public Basket() {
    }

    public Basket(Customer customerId, Commodity idCommodity) {
        this.customerId = customerId;
        this.idCommodity = idCommodity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer idCustomer) {
        this.customerId = idCustomer;
    }

    public Commodity getIdCommodity() {
        return idCommodity;
    }

    public void setIdCommodity(Commodity idCommodity) {
        this.idCommodity = idCommodity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

        return id.equals(basket.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
