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
    
    public double getWeight(){
        return this.weight;
    }

    public String getStyle(){
        return this.style;
    }
    
    public String getRecord(){
        return this.record;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n\tWeight: " + this.weight + "\n\tStyle: " + this.style
            + "\n\tRecord: " + this.record;
    }

    @Override
    public void display(){
        System.out.println("<<<Fighter>>>" + this);
    } 

   }