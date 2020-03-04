package model;

import java.util.ArrayList;

public class ApprovedList {
    
    private ArrayList<String> qualifiedTeacher;

    public ApprovedList() {
        qualifiedTeacher = new ArrayList<>();
    }
    public ArrayList<String> getQualifiedTeacher() {
        return qualifiedTeacher;
    }
}