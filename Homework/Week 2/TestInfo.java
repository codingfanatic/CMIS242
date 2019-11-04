/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestInfo {

    public static void main(String[] args) {
        BufferedReader inputStream = null;

        String fileLine;
        try {
            inputStream = new BufferedReader(new FileReader("Info.txt"));

            System.out.println("Employees: "); int i = 1;
            // Read one Line using BufferedReader
            while ((fileLine = inputStream.readLine()) != null) {
                String og = fileLine;
                String year = og.substring(0, fileLine.indexOf(" "));
                
                og = og.substring(year.length() + 1, og.length());
                String employeeType = og.substring(0, og.indexOf(" "));
                
                og = og.substring(employeeType.length() + 1, og.length());
                String employeeName = og.substring(0, og.indexOf(" "));

                og = og.substring(employeeName.length() + 1, og.length());
                
                String employeeMonthlySalary = "";
                if (!og.contains(" "))
                    employeeMonthlySalary = og.substring(0, og.length());
                else
                    employeeMonthlySalary = og.substring(0, og.indexOf(" "));
                
                String employeeExtraInfo = "";

                if (!(employeeType.equals("Employee"))){
                    og = og.substring(employeeMonthlySalary.length() + 1, og.length());
                    employeeExtraInfo = og.substring(0, og.length());
                }

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
        
        }
    }
}