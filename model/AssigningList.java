package model;

import java.util.HashMap;
import java.util.Map;

public class AssigningList {
    private Map<Subject, Teacher> pairedMap;

    public AssigningList() {
        /**
         * doesn't take any variables when initiated so can be created at start of
         * program and add pairs when they have been assigned to teach a course
         */
        pairedMap = new HashMap<Subject, Teacher>();
    }

    public void addPair(Subject subject, Teacher teacher) {
        /**
         * adds a teacher and a training course par
         */
        pairedMap.put(subject, teacher);
    }

    public Map<Subject, Teacher> getAssigningList() {
        /**
         * returns the hashmap
         */
        return pairedMap;
    }

    public String[] stringArray() {
        /**
         * changes the hashmap into a string array so that it can be displayed in the
         * ptt Director window
         */
        String[] array = new String[pairedMap.size()];
        String str = null;
        int counter = 0;
        for (Map.Entry<Subject, Teacher> entry : pairedMap.entrySet()) {
            str = String.format(entry.getKey().toString() + " : " + entry.getValue().toString());
            array[counter] = str;
            counter++;

        }

        return array;

    }
}