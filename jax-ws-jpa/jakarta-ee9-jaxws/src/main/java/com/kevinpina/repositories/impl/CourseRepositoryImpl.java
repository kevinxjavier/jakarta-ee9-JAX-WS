package com.kevinpina.repositories.impl;

import com.kevinpina.models.Course;
import com.kevinpina.repositories.CourseRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class CourseRepositoryImpl implements CourseRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course save(Course course) {
        em.persist(course);
        return course;
    }

}
