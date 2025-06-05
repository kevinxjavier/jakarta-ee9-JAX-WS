package com.kevinpina.services;

import com.kevinpina.models.Course;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CourseServiceWS {

    String inform(String message);
    List<Course> list();
    Course create(Course course);

}
