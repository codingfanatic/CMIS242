/* 
Executive.java
Richard Clarke
11-03-19
A class used to instantiate Salesman objects using names, monthly salaries, and annual sales.
This class extends the Employee class.

The first is Salesman. 
1. It has an additional instance variable that contains the annual sales in whole dollars 
for that salesman. 

2. A constructor that allows the name, monthly salary and annual sales to be initialized.

3. An overridden method annualSalary that returns the salary for a whole year. The salary for a
    salesman consists of the base salary computed from the monthly salary plus a commission.
    The commission is computed as 2% of that salesman's annual sales. 

4. The maximum commission a salesman can earn is $20,000.

5. An overridden toString method that returns a string containing the 
    name, 
    monthly salary and
    annual sales, appropriately labeled.
*/

/*
1. It has an additional instance variable that contains the annual sales 
   in whole dollars for that salesman. 
*/
class Salesman extends Employee{
    private String name;
    private double monthlySalary, annualSales;

    public Salesman(){
        super();
        annualSales = 0.00;
    }

/*
2. A constructor that allows the name, monthly salary and annual sales to be initialized.
*/    
    public Salesman(String name, double monthlySalary, double annualSales){
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

/*
3. An overridden method annualSalary that returns the salary for a whole year. 
   The salary for a salesman consists of the base salary computed from the 
   monthly salary plus a commission. 
   The commission is computed as 2% of that salesman's annual sales. 
*/

    @Override
    public double annualSalary(){
        double commission = (.02 * annualSales);
/*
4. The maximum commission a salesman can earn is $20,000.        
*/      
        if (commission > 20000){
            commission = 20000;
        }

        return (super.annualSalary() + commission);
    }
/*
5. An overridden toString method that returns a string containing the 
    name, monthly salary and annual sales, appropriately labeled.
*/
    public String toString(){
        return super.toString() +
               "\n\tAnnual Sales: $" + annualSales;
    }
}