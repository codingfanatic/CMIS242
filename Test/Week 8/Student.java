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

    //ToSTring overridden 
}

class TestStudent{
    public static void main(String[] args){
        Student a = new Student("Rick", "Computah");
        a.courseCompleted('A', 3);
        System.out.println(a.getQualityPoints());
    }
}