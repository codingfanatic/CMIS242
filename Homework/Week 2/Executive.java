/*
1. It has an additional instance variable that reflects the current stock price. 

2. A constructor that allows the name, monthly salary and stock price to be initialized.
   
3. An overridden method annualSalary that returns the salary for a whole year. 
   The salary for an executive consists of the base salary computed from the monthly salary 
   plus a bonus. 
   The bonus is $30,000 if the current stock price is greater than $50 and nothing otherwise.

4. An overridden toString method that returns a string containing the name, monthly salary and
   stock price, appropriately labeled.
*/

class Executive extends Employee{
/*
1. It has an additional instance variable that reflects the current stock price. 
*/
    private String name;
    private double monthlySalary, currentStockPrice;

    public Executive(){
        super();
        currentStockPrice = 0.00;
    }

/*
2. A constructor that allows the name, monthly salary and stock price to be initialized.
*/
    public Executive(String name, double monthlySalary, double currentStockPrice){
        super(name, monthlySalary);
        this.currentStockPrice = currentStockPrice;
    }

/*
3. An overridden method annualSalary that returns the salary for a whole year. 
   The salary for an executive consists of the base salary computed from the monthly salary 
   plus a bonus. 
   The bonus is $30,000 if the current stock price is greater than $50 and nothing otherwise.   
*/
   @Override
    public double annualSalary(){
        double bonus = 0.00;

            if(currentStockPrice > 50){
                bonus = 30000;
            }

        return (super.annualSalary() + bonus);
    }
 
/*
4. An overridden toString method that returns a string containing the name, monthly salary and
    stock price, appropriately labeled.
*/
    public String toString(){
        return super.toString() +
               "\n\tStock Price: $" + currentStockPrice;
    }
}