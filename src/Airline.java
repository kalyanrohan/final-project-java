import java.time.*;
import java.util.ArrayList;
public class Airline implements Details {
    private String airlineName;
    private String flightNumber;
    private String Destination;
    private LocalDateTime departure;
    private LocalDateTime estArrival;
    private int gateNumber;
    private float ticketPrice;
    private ArrayList<Passenger>passengerlist=new ArrayList<>();

    public Airline(String airlineName,String flightNum,String Dest,LocalDateTime dep,LocalDateTime avl,int gateNumber,
                   float ticketPrice){
        this.airlineName=airlineName;
        this.flightNumber=flightNum;
        this.Destination=Dest;
        this.departure=dep;
        this.estArrival=avl;
        this.gateNumber=gateNumber;
        this.ticketPrice=ticketPrice;
    }
//setters
    public void setFlightName(String name) {
        this.airlineName = name;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDeparture(int hour,int minute,int year,int month,int day) { this.departure = LocalDateTime.of(year,
            month,day,hour,minute); }

    public void setEstArrival(int hour,int minute,int day,int month,int year) {
        this.estArrival = LocalDateTime.of(year,month,day,hour,minute);
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //getters
    public String getFlightName() {
        return airlineName;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public String getDestination() {
        return Destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getEstArrival() {
        return estArrival;
    }

    public int getGateNum() {
        return gateNumber;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public boolean isFullCapacity(ArrayList<Passenger> passengerList){
        boolean fullCapacity = Boolean.FALSE;
        int maximumCapacity = 100;
        if(passengerList.size()== maximumCapacity){
            fullCapacity =Boolean.TRUE;
        }
        return fullCapacity;
    }

    public void addPassengers(Passenger passenger){
        if(isFullCapacity(passengerlist)==Boolean.FALSE){
            passengerlist.add(passenger);
        }
        else{
            System.out.println("Airline have reached maximum capacity. ");
        }
    }




}
