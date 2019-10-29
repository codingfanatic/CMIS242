class corvus {
    private static String habitat = "Forest", dietGroup = "Omnivore";
    private float length;
    private String color;
    
    public corvus(float length, String color){
        this.length = length;
        this.color = color;
    }
    public String getHabitat(){
        return habitat;
    }

    public String getDietGroup(){
        return dietGroup;
    }

    public float getLength(){
        return length;
    }

    public void setLength(String length){
        this.length = length;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

}
