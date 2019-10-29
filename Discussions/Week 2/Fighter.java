class Fighter extends Person{
    private double weight;
    private String style;
    private String record;
    private static int fighterCount = 0;

    public Fighter(){
        super();
        weight = 0;
        style = "";
        record = "";
    }
    public Fighter(String name, int id, double weight, String style, String record){
        super(name, id);
        this.weight = weight;
        this.style = style;
        this.record = record;
    }
    
    //getWeight
    //getStyle
    //getRecord
    //toString
    

    //Fighter will override toString() using super 
    //and return vals of instance vars with proper labels

    //display 

   }