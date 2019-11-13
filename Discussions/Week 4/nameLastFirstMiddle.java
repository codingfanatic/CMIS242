//Class for formatting a name
public class nameLastFirstMiddle implements Formattable{
    public String fullName(String firstName, String lastName, String middleName){
        return lastName + "," + " " + firstName + " " + middleName.charAt(0);
    }
}