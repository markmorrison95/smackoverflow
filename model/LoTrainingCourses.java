package model;

import java.util.ArrayList;

public class LoTrainingCourses{
    protected String courseID;
    protected ArrayList<TrainingCourse> listOfTC;
    protected int numOfCourses;

    // list constructor
    // passed an int, for number of indices?
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

    // getters
    public ArrayList<TrainingCourse> getListOfTC() {
        return listOfTC;
    }
    public void printTcourses(){
        for(TrainingCourse tc : listOfTC){
            System.out.println(tc);
        }
    }
}