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
    
    You may assume that the file will contain no more than ten employee records for each year 
    and that the data in the file will be formatted correctly.

    Once all the employee data is read in, a report should be displayed on the 
    console for each of the two years. 
    
    Each line of the report should contain all original data supplied for each employee together with 
    that employee's annual salary for the year. 

    For each of the two years, an average of all salaries for all employees for that year 
    should be computed and displayed.
*/
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test{
    public static void main(String[] args){

        ArrayList array2014 = new ArrayList();
        ArrayList array2015 = new ArrayList();

        String year = "";
        String employeeType = "";
        String employeeName = "";
        String employeeMonthlySalary = "";
        String employeeExtraInfo = "";

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

                System.out.println("Employees: "); int i = 1;
                // Read one Line using BufferedReader
                while ((fileLine = inputStream.readLine()) != null) {
                    year = fileLine.substring(0, fileLine.indexOf(" "));
                    
                    fileLine = fileLine.substring(year.length() + 1, fileLine.length());
                    employeeType = fileLine.substring(0, fileLine.indexOf(" "));
                    
                    fileLine = fileLine.substring(employeeType.length() + 1, fileLine.length());
                    employeeName = fileLine.substring(0, fileLine.indexOf(" "));

                    fileLine = fileLine.substring(employeeName.length() + 1, fileLine.length());
                
                        if (!fileLine.contains(" "))
                         employeeMonthlySalary = fileLine.substring(0, fileLine.length());
                      else
                         employeeMonthlySalary = fileLine.substring(0, fileLine.indexOf(" "));
                    
                    employeeExtraInfo = "";

                        if (!(employeeType.equals("Employee"))){
                            fileLine = fileLine.substring(employeeMonthlySalary.length() + 1, fileLine.length());
                            employeeExtraInfo = fileLine.substring(0, fileLine.length());
                        }
/*
2.  As the employees are read in, Employee objects of the appropriate type should be created 
    and they should be stored in one of two arrays depending upon the year. 
*/                  
                            if (employeeType.equals("Employee")){
                                e = new Employee(employeeName, employeeMonthlySalary);
                            }
                            /*
                           //else if (/*Salesman*/
                                //Instantiate Salesman
                          //  }
                          //  else{
                                //Instantiate Executive
                         //   }
                        
                          //  if (year.equals("2014"))
                                //Add to 2014 array
                         //   else
                                //Add to 2015 array
                                
                    System.out.println(employeeExtraInfo);
                }
            } catch (IOException io) {
                System.out.println("File IO exception" + io.getMessage());
            }finally {
                // Need another catch for closing 
                // the streams          
                try {               
                    if (inputStream != null) {
                    inputStream.close();
                }                
                } catch (IOException io) {
                    System.out.println("Issue closing the Files" + io.getMessage());
                }
       
    }}
}