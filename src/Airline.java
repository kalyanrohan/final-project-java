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
    //array list to store passengers
    private ArrayList<String>passengerList=new ArrayList<>();

    //constructor
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
    //default constructor
    public Airline(){
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

    public ArrayList<String> getPassengerList() {
        return passengerList;
    }

    //to check if airline already reach maximum capacity
    //if max capacity reached then return True
    public boolean isFullCapacity(){
        boolean fullCapacity = Boolean.FALSE;
        int maximumCapacity = 100;
        if(passengerList.size()>= maximumCapacity){
            fullCapacity =Boolean.TRUE;
        }
        return fullCapacity;
    }

    //to add passengers to the passenger array list
    //checks if airline have reached max capacity, if not then add passenger to array list
    public void addPassengers(Passenger passenger){
        if(isFullCapacity()==Boolean.FALSE){
            passengerList.add(passenger.getFirstName()+" "+passenger.getLastName());
        }
        else{
            System.out.println("Airline have reached maximum capacity. ");
        }
    }

}
