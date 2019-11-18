public interface NintendoConsole{
    final boolean regionLocked = false;
    void setNumberOfControllers(int i);
    void setDeviceName(String s);
}

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
        this.numberOfControllers = i;
    }

    @Override
    public void setDeviceName(String s){
        this.deviceName = s;
    }

    public boolean hasOnline(){
        if(this.deviceName.contains("2001"))
            return true;
        else
            return false;
    }
}