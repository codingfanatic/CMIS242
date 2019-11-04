/*
1. The first class is the Employee class, 
2. The class contains the employee's name and monthly salary, which
    is specified in whole dollars. 
3. It should have three methods:
   A constructor that allows the name and monthly salary to be initialized.
   A method named annualSalary that returns the salary for a whole year.
  A toString method that returns a string containing the name and monthly salary, appropriately labeled.
*/
//1. The first class is the Employee class, 
//2. The class contains the employee's name and monthly salary
class Employee{
    private String name;
    private double monthlySalary;

    public Employee(){
        name = "";
        monthlySalary = 0.00;
    }

//3. It should have three methods:
 //A constructor that allows the name and monthly salary to be initialized.
    public Employee(String name, double monthlySalary){
        this.name = name;
        this.monthlySalary = monthlySalary;
    }


 //A method named annualSalary that returns the salary for a whole year.
 //12 * monthly salary    
    public double annualSalary(){
        return 12 * monthlySalary;
//*****************SET PRECISION TO TWO DECIMAL PLACES */
    }
 
 //A toString method that returns a string containing the name and monthly salary, appropriately labeled.
    public String toString(){
        return "\n\tName: " + name + 
               "\n\tMonthly Salary: $" + monthlySalary;
//*****************SET PRECISION TO TWO DECIMAL PLACES */
    }
}