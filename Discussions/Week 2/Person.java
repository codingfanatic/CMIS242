class Person{
    //Id should be an int variable
    private String name, id;
    private static int idCount = 0;
    
    //Add a constructor which accepts name and id and increments idCount

    //Display method should have the format <<Obj>>>
    //Only print the object, not Object.toString()
    public void display(){
        System.out.println("<<<Person>>>" + this.toString());
    }
    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    //Include specific String formatting
    //"\n\tId: " + id + name;
    public String toString(){
        return this.toString();
    }
   }