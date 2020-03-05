package model;

import java.util.ArrayList;

public class LoTrainingCourses{
    protected String courseID;
    protected ArrayList<TrainingCourse> listOfTC;

    // constructor
    public LoTrainingCourses() {
        listOfTC = new ArrayList<TrainingCourse>();
    }

    // adds a training course to the array list
    public void addCourse(TrainingCourse trainingCourse){
                listOfTC.add(trainingCourse);
    }

    // removes a training course from the array list
    public void removeCourse(TrainingCourse trainingCourse){
                listOfTC.remove(trainingCourse);
    }

    // get list of training courses
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
