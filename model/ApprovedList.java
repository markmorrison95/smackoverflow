package model;

import java.util.ArrayList;

public class ApprovedList {
    
    private ArrayList<String> qualifiedTeacher;

    public ApprovedList() {
        /**
         * doesn't take any variables when initiated so can be created at start of program
         * and add when a teacher and class pairing
         */
        qualifiedTeacher = new ArrayList<>();
    }
    public ArrayList<String> getQualifiedTeacher() {
        return qualifiedTeacher;
    }
}