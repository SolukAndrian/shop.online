package ua.lviv.sombra.entity;

import javax.persistence.*;

/**
 * Created by Apple on 12.04.2017.
 */
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Customer idCustomer;
    @ManyToOne
    private Commodity idCommodity;
    public Basket() {
    }

    public Basket(Customer idCustomer, Commodity idCommodity) {
        this.idCustomer = idCustomer;
        this.idCommodity = idCommodity;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Commodity getIdCommodity() {
        return idCommodity;
    }

    public void setIdCommodity(Commodity idCommodity) {
        this.idCommodity = idCommodity;
    }
}
