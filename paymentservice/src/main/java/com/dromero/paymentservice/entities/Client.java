package com.dromero.paymentservice.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private int personalDocumentNumber;
    private int amountPayment;
    private boolean active;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPersonalDocumentNumber() {
        return personalDocumentNumber;
    }

    public void setPersonalDocumentNumber(int personalDocumentNumber) {
        this.personalDocumentNumber = personalDocumentNumber;
    }

    public int getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(int amountPayment) {
        this.amountPayment = amountPayment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}