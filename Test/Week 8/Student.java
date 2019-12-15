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

class TestStudent{
    public static void main(String[] args){
        Student a = new Student("Rick", "Computah");
        //a.courseCompleted('D', 3);
        System.out.println(a.getQualityPoints());
        System.out.println(a.toString());
    }
}