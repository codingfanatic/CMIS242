//Class for formatting a name
public class nameLastFirstMiddle implements Formattable{
    public String combineNames(String firstName, String middleName, String lastName){
        return lastName + "," + " " + firstName + " " + middleName.charAt(0);
    }
}