package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
    private final EntityManager entityManager;
    //constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        //fetch instructor by id
        Instructor instructor = entityManager.find(Instructor.class, id);
        //delete the fetched instructor
        entityManager.remove(instructor);
    }
    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }
    @Transactional
    @Override
    public void deleteInstructorDetailById(int id) {
        //fetch the instructor detail from database
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
        //remove the associated object reference
        //break bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        //delete the fetched instructor
        entityManager.remove(instructorDetail);
    }


}
