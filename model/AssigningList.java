package model;

import java.util.HashMap;
import java.util.Map;

public class AssigningList {
    private Map<Subject, Teacher> pairedMap;
    public AssigningList(){
        pairedMap = new HashMap<Subject, Teacher>();
    }

    public void addPair(Subject course, Teacher teacher){
        pairedMap.put(course, teacher);
    }
    public Map<Subject, Teacher> getAssigningList(){
        return pairedMap;
    }
    public String[] stringArray() {
        String[] array = new String[pairedMap.size()];
        String s = null;
        int counter = 0;
        for (Map.Entry<Subject, Teacher> entry : pairedMap.entrySet()) {
            s = String.format(entry.getKey().toString() + " : " + entry.getValue().toString());
            array[counter] = s;
            counter++;

        }

        return array;

    }
}