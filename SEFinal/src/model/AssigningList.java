package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AssigningList {

    public ArrayList<String> a;

    public Map<Course, Teacher> pairedMap;

    public AssigningList() {
        pairedMap = new HashMap<Course, Teacher>();
        a = new ArrayList<String>();
    }

    public void addPair(Course course, Teacher teacher) {

        pairedMap.put(course, teacher);

    }

    public Map<Course, Teacher> getAssigningList() {

        Teacher Jesus = new Teacher("Jesus");
        Course Carpentry = new Course ("Carpentry");

        Teacher Noah = new Teacher("Moses");
        Course RedSea = new Course ("How to Part the Sea");

        Teacher Eve = new Teacher("Eve");
        Course EatingApple = new Course ("Eating Apples & Fucking Things Up");

        addPair(Carpentry, Jesus);
        addPair(RedSea, Noah);
        addPair(EatingApple, Eve);

        return pairedMap;

    }

    public String[] stringArray() {
        String[] array = new String[3];
        String s = null;
        int counter = 0;
        for (Map.Entry<Course, Teacher> entry : pairedMap.entrySet()) {
            s = String.format(entry.getKey().toString() + " : " + entry.getValue().toString());
            array[counter] = s;
            counter++;

        }

        return array;

    }

}

