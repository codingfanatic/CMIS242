import java.sql.Time;

class Train{
    private Time arrivalTime;
    private String state;

    public Train(){
        arrivalTime = new Time(0);
        state = "Arriving";
    }

    public Train(long milliseconds, String state){
        arrivalTime = new Time(milliseconds);
        this.state = state;
    }

    public Time getArrivalTime(){
        return arrivalTime;
    }

    public String getState(){
        return state;
    }

}