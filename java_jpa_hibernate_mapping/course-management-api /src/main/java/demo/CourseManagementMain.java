package demo;

import entities.*;
import models.CourseModel;
import models.StudentModel;

public class CourseManagementMain {

    public static void main(String[] args) {

       
        Student student = new Student("John Student");
        student.addAddress(new Address("Baker Street 221B"));
        student.addPhone(new Phone("+994501112233"));
        student.setName("John Student");

       
        Teacher teacher = new Teacher("Mr. Teacher");

     
        Course course = new Course("Java Backend 101");
        course.setTeacher(teacher);
        course.addStudent(student);

        
        CourseMaterial material = new CourseMaterial("https://example.com/java-material");
        course.setMaterial(material);
        StudentModel studentModel = new StudentModel();
        studentModel.create(student);
        teacher.addCourse(course);
        CourseModel courseModel = new CourseModel();
        courseModel.create(course);

        System.out.println("Done. Tables created and sample data inserted.");
    }
}
