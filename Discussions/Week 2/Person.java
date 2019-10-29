class Person{
    private String name;
    private int id;
    private static int idCount = 0;
    
    public Person(){

    }

    public Person(String name, int id){
        this.name = name;
        this.id= id;
        ++idCount;
    }
    
    public void display(){
        System.out.println("<<Person>>>" + this);
        //this keyword invokes the instance toString() method
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public String toString(){
        return "\n\tId: " + id + "\n\tName: " + name;
    }
   }