package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    private int id;
    private String number;
    private List<Item> items;

    public Invoice() {

    }

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    @Id
    @GeneratedValue
    @Column(name = "INVOICE_ID", unique = true)
    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "INVOICE_NUMBER")
    public String getNumber() {
        return number;
    }
    private void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }
    private void setItems(List<Item> items) {
        this.items = items;
    }


}
