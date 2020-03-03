package model;

import java.util.HashMap;
import java.util.Map;

public class AssigningList {
    private Map<Course, Teacher> pairedMap;
    public AssigningList(){
        pairedMap = new HashMap<Course, Teacher>();
    }

    public void addPair(Course course, Teacher teacher){
        pairedMap.put(course, teacher);
    }
    public Map<Course, Teacher> getAssigningList(){
        return pairedMap;
    }
}