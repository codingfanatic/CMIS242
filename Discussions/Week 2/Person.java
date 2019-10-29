class Person{
    private String name;
    private int id;
    private static int idCount = 0;
    
    //Add a constructor which accepts name and id and increments idCount
    public Person(String name, int id){
        this.name = name;
        this.id= id;
        ++idCount;
    }
    //Display method should have the format <<Obj>>>
    //Only print the object, not Object.toString()
    public void display(){
        System.out.println("<<<Person>>>" + this.toString());
    }
    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    //Include specific String formatting
    //"\n\tId: " + id + name;
    public String toString(){
        return this.toString();
    }
   }