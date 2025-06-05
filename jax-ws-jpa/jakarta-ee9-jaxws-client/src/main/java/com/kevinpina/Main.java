package com.kevinpina;

import com.kevinpina.services.Course;
import com.kevinpina.services.CourseServiceWS;
import com.kevinpina.services.CourseServiceWSImplService;

public class Main {

    public static void main(String[] args) {

        // Setting these Properties to print the XML request used to call the WebService.
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");

        CourseServiceWS courseServiceWS = new CourseServiceWSImplService().getCourseServiceWSImplPort();

        System.out.println(courseServiceWS.inform("Hola Mundo"));

        Course course = new Course();
        course.setName("Microsoft");
        course.setDescription("To be defined");
        Course courCreated = courseServiceWS.create(course);
        System.out.println("ID: " + courCreated.getId() + ", Name: " +courCreated.getName());

        courseServiceWS.list().forEach(c -> System.out.println(c.getName()));
    }

}
