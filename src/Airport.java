import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Airport {
    public String name;
    public String location;
    public ArrayList<Airline> airlines=new ArrayList<>();
    public ArrayList<Passenger>passengers=new ArrayList<>();
    public Scanner sc= new Scanner(System.in);
    public Airport(String Name,String Location){
        this.location=Location;
        this.name=Name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void addAirline(String airlineName, String flightNum, String Dest, LocalDateTime dep, LocalDateTime avl,int gateNumber,float ticketPrice){
        Airline airline=new Airline(airlineName,flightNum,Dest,dep,avl,gateNumber,ticketPrice);
        airlines.add(airline);
    }
    public void displayAirlines() {
        for (Airline airline : airlines) {
            System.out.println(airline.getFlightName());
            System.out.println(airline.getFlightNumber());
            System.out.println(airline.getDestination());
            System.out.println(airline.getDeparture());
            System.out.println(airline.getEstArrival());
            System.out.println(airline.getGateNum());
            System.out.println();
        }
    }

    public void buyTicket(Account passenger){
        String input;
        System.out.println("Please enter your destination.");
        input=sc.nextLine();


    }
}
