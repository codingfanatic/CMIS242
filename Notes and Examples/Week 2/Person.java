//Person.java
class Person {
    //Static variable for counting Person instances
    private static int idCount = 0;
    //Instance variables
    private Name name;     
    private int id;        
       //Constructor initializing instance variables with supplied names
    public Person(String firstName, String lastName) {
       name = new Name(firstName, lastName);     
       id =  ++idCount;       
    }
    //Present a Person object as a string
    public String toString() {    
       return "\n\tId: " + id + name;
    }
    //Display the data of a Person object
    public void display() {
       System.out.println("<<Person>>>" + this);    
    }
 }