package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class AppDAOImpl implements AppDAO{
    private final EntityManager entityManager;
    //constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
