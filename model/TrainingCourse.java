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

    // gets course name
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

    // gets list of teachers
    public ArrayList<Teacher> getListOfTeachers(){
        return listOfTeachers;
    }
    
    // adds tecaher to a list of teachers
    public void addTeacherToCourse(Teacher teacher){
        listOfTeachers.add(teacher);
    }
    
    // to string method
    public String toString(){
        return courseName + " " + subjectName;
    }
}
