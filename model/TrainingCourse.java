package model;

import java.util.ArrayList;

public class TrainingCourse {
    
    private String courseName;
    private String subjectName;
    private Teacher teacherName;
    private ArrayList<Teacher> listOfTeachers;

    public TrainingCourse(String name, String subject){
        /**
         * constructor takes the name of training course and the name of the subject
         * it is linked with
         * has an array list of teachers so when a teacher is added to the training course they
         * are stored here
         */
        this.courseName = name;
        this.subjectName = subject;
        listOfTeachers = new ArrayList<Teacher>();
    }

    /**
     * getters and setters for variables
     */
    public String getCourseName(){
        return courseName;
    }
    
    // gets subject name
    public String getSubjectName(){
        return subjectName;
    }

    // set teacher variable
    public void setTeacher(Teacher teacher){
        this.teacherName = teacher;
    }

    // gets teacher name
    public Teacher getTeacher(){
        return this.teacherName;
    }
    
    // to string method
    public String toString(){
        return courseName + " " + subjectName;
    }
}
