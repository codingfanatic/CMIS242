public class TestPolymorphism {
    public static void main(String[] args)  {
       Person persons [] = new Person [5];
       persons[0] = new Person("Mary", "Wisp");
       persons[1] = new Employee("George", "Brown", 40000);
       persons[2] = new Student("John", "Smith", 2.86);
       persons[3] = new Student("Greta", "Mark", 3.59);
       persons[4] = new Employee("Julia", "Kitar", 50600);
       displayAllPersons(persons);
    }
 
    public static void displayAllPersons(Person[] persons) {
       for (int i = 0; i < persons.length; i++) {
          persons[i].display();
       }
    }
 }