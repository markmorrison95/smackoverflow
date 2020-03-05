package model;

import java.util.ArrayList;

public class LoTrainingCourses{
    private ArrayList<TrainingCourse> listOfTC;

    public LoTrainingCourses() {
        /**
         * doesn't take any variables when initiated so can be created at start of program
         * and add courses when the file is read in
         */
        listOfTC = new ArrayList<TrainingCourse>();
    }

    // adds a training course to the array list
    public void addCourse(TrainingCourse trainingCourse){
        /**
         * add training course to the list
         */
        listOfTC.add(trainingCourse);
    }

    /**
     * getters for variables
     */
    public ArrayList<TrainingCourse> getListOfTC() {
        return listOfTC;
    }
    
    // print method
    public void printTcourses(){
        for(TrainingCourse tc : listOfTC){
            System.out.println(tc);
        }
    }
}
