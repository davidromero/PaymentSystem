package com.dromero.paymentservice.repositories;

import com.dromero.paymentservice.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientRepository {

    @PersistenceContext(name = "Client_PU")
    EntityManager em;

    public Client findById(Long id) {
        return em.find(Client.class, id);
    }

    public void create(Client client) {
        em.persist(client);
    }

    public Client findByName(String name){
        Query query = em.createQuery("FROM Client E WHERE E.name = :clientname");
        query.setParameter("clientname", name);
        List<Client> clients = query.getResultList();
        return clients.get(0);
    }
}
