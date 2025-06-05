package com.kevinpina.services.impl;

import com.kevinpina.models.Course;
import com.kevinpina.services.CourseServiceWS;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "com.kevinpina.services.CourseServiceWS") // Generate SOAP for interface methods only and not for all methods defines in this class
public class CourseServiceWSImpl implements CourseServiceWS {

    private int count;  // Will increase the count because behave Stateless so (this) below will show the same every call, e.g.: com.kevinpina.services.impl.CourseServiceWSImpl@b413483

    @WebMethod
    @Override
    public String inform(String message) {
        System.out.println("Person [" + count++ + "]. Printing inside WS implementation with instance: " + this);
        return "Service to create courses.";
    }

    @WebMethod
    @Override
    public List<Course> list() {
        return List.of(Course.builder().name("Java").build(),
                Course.builder().name("PHP").build(),
                Course.builder().name("Python").build());
    }

    @WebMethod
    @Override
    public Course create(Course course) {
        System.out.println("Course " + course.getName() + " saved successful!");
        return Course.builder().name(course.getName()).build();
    }

}
