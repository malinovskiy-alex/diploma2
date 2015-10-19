package com.malinovskiy.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class ClusterRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Address save(Address clientOrder) {
        entityManager.persist(clientOrder);
        return clientOrder;
    }

    public List<Address> findAll() {
        return entityManager.createNamedQuery(Address.FIND_All).getResultList();
    }
}
