package model;

import java.util.ArrayList;

public class TrainingCourse {
    
    private String courseName;
    private String subjectName;
    private Teacher teacherName;
    private ArrayList<Teacher> listOfTeachers;

    // constructor
    public TrainingCourse(String name, String subject){
        this.courseName = name;
        this.subjectName = subject;
        listOfTeachers = new ArrayList<Teacher>();
    }

    public String getCourseName(){
        return courseName;
    }
    public String getSubjectName(){
        return subjectName;
    }

    public void setTeacher(Teacher teacher){
        this.teacherName = teacher;
    }

    public Teacher getTeacher(){
        return this.teacherName;
    }

    public ArrayList<Teacher> getListOfTeachers(){
        return listOfTeachers;
    }
    public void addTeacherToCourse(Teacher teacher){
        listOfTeachers.add(teacher);
    }
    public String toString(){
        return courseName + " " + subjectName;
    }
}