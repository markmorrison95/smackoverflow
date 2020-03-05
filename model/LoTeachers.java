package model;

import java.util.ArrayList;

public class LoTeachers {
    private ArrayList<Teacher> listOfTeachers;

    public LoTeachers(){
        /**
         * doesn't take any variables when initiated so can be created at start of program
         * and add teachers when the file is read in
         */
        this.listOfTeachers = new ArrayList<>();
    }

    public ArrayList<Teacher> getListOfTeachers(){
        return this.listOfTeachers;
    }

    public void addTeacher(Teacher teacher){
        listOfTeachers.add(teacher);
    }
}