class GameCube implements NintendoConsole{
    int numberOfControllers;
    String deviceName; 
    String color;
    String version;

    GameCube(String color, String version){
        this.color = color;
        this.version = version;
    }

    @Override
    public void setNumberOfControllers(int i){
        this.numberOfControllers = 4;
    }

    @Override
    public void setDeviceName(String s){
        this.deviceName = s;
    }
}