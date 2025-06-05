package com.kevinpina;

import com.kevinpina.services.Course;
import com.kevinpina.services.impl.CourseServiceWS;
import com.kevinpina.services.impl.CourseServiceWSImplService;

public class Main {

    public static void main(String[] args) {
        CourseServiceWS courseServiceWS = new CourseServiceWSImplService().getCourseServiceWSImplPort();
        System.out.println(courseServiceWS.inform("Hola Mundo"));

        Course course = new Course();
        course.setName("Microsoft");
        Course courCreated = courseServiceWS.create(course);
        System.out.println(courCreated.getName());

        courseServiceWS.list().forEach(c -> System.out.println(c.getName()));
    }

}
