package com.dromero.paymentservice.repositories;

import com.dromero.paymentservice.entities.Payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PaymentRepository {

    @PersistenceContext(name = "Payment_PU")
    EntityManager em;

    public List getAllPayments() {
        return em.createNamedQuery("Payment.findAll", Payment.class).getResultList();
    }

    public void create(Payment payment) {
        em.persist(payment);
    }
}
