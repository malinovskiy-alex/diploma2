package com.malinovskiy.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Александр on 14.12.2014.
 */
@Repository
@Transactional(readOnly = true)
public class ClientOrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ClientOrder save(ClientOrder clientOrder) {
        entityManager.persist(clientOrder);
        return clientOrder;
    }

    public List<ClientOrder> findAll() {
        return entityManager.createNamedQuery(ClientOrder.FIND_All).getResultList();
    }

}
