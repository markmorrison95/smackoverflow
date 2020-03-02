package model;

import java.util.ArrayList;

public class TrainingCourse {
    
    private String courseName;
    private String subjectName;
    private ArrayList<Teacher> listOfTeachers;

    // constructor
    public TrainingCourse(String name, String subjectName){
        this.courseName = name;
        this.subjectName = subjectName;
        listOfTeachers = new ArrayList<Teacher>();
    }

    public String getCourseName(){
        return courseName;
    }

    public ArrayList<Teacher> getListOfTeachers(){
        return listOfTeachers;
    }
    public void addTeacherToCourse(Teacher teacher){
        listOfTeachers.add(teacher);
    }
    public String toString(){
        return "" + courseName + " " + subjectName;
    }
}