/*
StudentDatabase.java
Richard Clarke
12-13-19
A class used to define Student objects for the StudentDatabase class. Students have a name, 
makor, number of credits completed, and quality points. Upon selecting Update in the StudentDatabase
class, the courseCompleted() method should be invoked calculating the GPA and Quality Points for a 
Student.
*/

import java.util.function.ToDoubleBiFunction;

public class Student{
    private String name;
    private String major;
    private int creditsCompleted;
    private double qualityPoints; //Credits * the grade 

    //Constructor
    public Student(String name, String major){
        this.name = name;
        this.major = major;
        creditsCompleted = 0;
        qualityPoints = 0;
    }

    //CourseCompleted method
    public void courseCompleted(char grade, int creditsCompleted){
        int points = 0;
        this.creditsCompleted = creditsCompleted;

        switch(grade){
            case('A'):  points = 4;
                        break;

            case('B'):  points = 3;
                        break;

            case('C'):  points = 2; 
                        break;

            case('D'):  points = 1;
                        break;

            default:    points = 0;
                        qualityPoints = 0; 
                        break;
        }
        qualityPoints = points * creditsCompleted;
    }

    public double getQualityPoints(){
        return this.qualityPoints;
    }

    public String getName(){
        return this.name;
    }


    public String getMajor(){
        return this.major;
    }

    @Override
    public String toString(){
        double points = 0;
            if (creditsCompleted == 0){
                points = 4;
            }
            else{
                points = getQualityPoints() / creditsCompleted;
            }
        return "Name: " + name + "\n" + "Major: " + major + "\n" + "GPA: " + points + "\nQuality Points: " + this.qualityPoints;
    }
}