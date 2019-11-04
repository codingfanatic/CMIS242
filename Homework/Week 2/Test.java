/*
1. Finally there should be a fourth class that contains the main method. 
    It should read in employee information from a text file. 
    Each line of the text file will represent the information for one employee
    for one year. 
    
    An example of how the text file will look is shown below:
        2014 Employee Smith,John 2000
        2015 Salesman Jones,Bill 3000 100000
        2014 Executive Bush,George 5000 55
            
    The year is the first data element on the line. 
    The file will contain employee information for only two years: 2014 and 2015. 

    Next is the type of the employee followed by the employee name and the monthly salary. 
    
    For salesmen, the final value is their annual sales 
    and for executives the stock price. 
    
2.  As the employees are read in, Employee objects of the appropriate type should be created 
    and they should be stored in one of two arrays depending upon the year. 
    
3. You may assume that the file will contain no more than ten employee records for each year 
    and that the data in the file will be formatted correctly.

4. Once all the employee data is read in, a report should be displayed on the 
    console for each of the two years. 
    Each line of the report should contain all original data supplied for each employee together with 
    that employee's annual salary for the year. 

    For each of the two years, an average of all salaries for all employees for that year 
    should be computed and displayed.
*/
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Double;

public class Test{
    public static void main(String[] args){

/*
3. You may assume that the file will contain no more than ten employee 
   records for each year.
   The ArrayList() constructor instantiates an empty list with an 
   inital capacity of ten.
*/
        List<Employee> array2014 = new ArrayList<Employee>();
        List<Employee> array2015 = new ArrayList<Employee>();

        String reportString2014 = "";
        Double averageSalary2014 = 0.0;
        String reportString2015 = "";
        Double averageSalary2015 = 0.0;
        String year = "";
        String employeeType = "";
        String employeeName = "";

        double employeeMonthlySalary = 0.00;
        double employeeExtraInfo = 0.00;

        Employee e;
/*
1. Finally there should be a fourth class that contains the main method. 
    It should read in employee information from a text file. 
    Each line of the text file will represent the information for one employee
    for one year. 
    
    An example of how the text file will look is shown below:
        2014 Employee Smith,John 2000
        2015 Salesman Jones,Bill 3000 100000
        2014 Executive Bush,George 5000 55
*/
        BufferedReader inputStream = null;

            String fileLine;
            try {
                inputStream = new BufferedReader(new FileReader("Info.txt"));

                // Read one Line using BufferedReader
                while ((fileLine = inputStream.readLine()) != null) {
                    year = getInfo(fileLine);

                        if (year.equals("2014"))
                            reportString2014 = reportString2014.concat(fileLine + " - Annual Salary :$");
                        else
                            reportString2015 = reportString2015.concat(fileLine + " - Annual Salary :$");
                    
                    fileLine = updateFileLine(fileLine, year);

                    employeeType = getInfo(fileLine);
                    fileLine = updateFileLine(fileLine, employeeType);
                    
                    employeeName = getInfo(fileLine);
                    fileLine = updateFileLine(fileLine, employeeName);

                    employeeMonthlySalary = getEmployeeMonthlySalary(fileLine);
                        
                        if (!(employeeType.equals("Employee"))){
                            employeeExtraInfo = getEmployeeExtraInfo(
                                                    fileLine.substring(
                                                        fileLine.indexOf(" "), fileLine.length()));
                        }
/*
2.  As the employees are read in, Employee objects of the appropriate type should be created 
    and they should be stored in one of two arrays depending upon the year. 
*/           
                        if (employeeType.equals("Employee")){
                            e = new Employee(employeeName, employeeMonthlySalary);
                        }
                        else if (employeeType.equals("Salesman")){
                            e = new Salesman(employeeName, employeeMonthlySalary, employeeExtraInfo);
                        }
                        else{
                            e = new Executive(employeeName, employeeMonthlySalary, employeeExtraInfo);
                        }
                        
                        if (year.equals("2014")){
                            array2014.add(array2014.size(),e);  
                            reportString2014 = reportString2014.concat(e.annualSalary() + "\n"); 
                            averageSalary2014 += e.annualSalary();
                            averageSalary2014 /= array2014.size();
                        }  
                        else if (year.equals("2015")){
                            array2015.add(array2015.size(), e);
                            reportString2015 = reportString2015.concat(e.annualSalary() + "\n");
                            averageSalary2015 += e.annualSalary();
                            averageSalary2014 /= array2014.size();
                        }

                }
/*
*************SET PRECISION
4. Once all the employee data is read in, a report should be displayed on the 
   console for each of the two years. 
   Each line of the report should contain all original data supplied for each employee together with 
   that employee's annual salary for the year. 
*/
                System.out.println("<<<2014>>>\n" + reportString2014 + "Average Salary = $" + averageSalary2014);
                System.out.println("<<<2015>>>\n" + reportString2015 + "Average Salary = $" + averageSalary2015);
            } 
            
            catch (IOException io) {
                System.out.println("File IO exception" + io.getMessage());
            }
            
            finally {
                // Need another catch for closing 
                // the streams          
                try {               
                    if (inputStream != null) {
                    inputStream.close();
                    }                
                } 
                
                catch (IOException io) {
                    System.out.println("Issue closing the Files" + io.getMessage());
                }
       
            }       
    }

    //Update fileLine String by removing Employee information
    public static String updateFileLine(String fileLine, String data){
        return fileLine.substring(data.length() + 1, fileLine.length());
    }
    public static String getInfo(String fileLine){
        return fileLine.substring(0, fileLine.indexOf(" "));
    }

    public static double getEmployeeMonthlySalary(String fileLine){

        if (!fileLine.contains(" ")){
            return Double.parseDouble(fileLine);
        }             
        else {
            return Double.parseDouble(
                   fileLine.substring(0, fileLine.indexOf(" ")));
        }
    }

    public static double getEmployeeExtraInfo(String fileLine){
        return Double.parseDouble(fileLine);
    }
}