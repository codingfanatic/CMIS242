class Attendee{
    private String name;
    private int tableNumber;

    public Attendee(){
        name = "Mr. Anderson";
        tableNumber = 1;
    }

    public Attendee(String name, int tableNumber){
        this.name = name;
        this.tableNumber = tableNumber;
    }

    public String getName(){
        return name;
    }

    public int getTableNumber(){
        return tableNumber;
    }

}