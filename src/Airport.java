import java.time.LocalDateTime;
import java.util.ArrayList;

public class Airport {
    public String name;
    public String location;
    public ArrayList<Airline> airlines=new ArrayList<>();
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
        int counter=1;
        for (Airline airline : airlines) {
            System.out.println(counter+". ");
            System.out.println("Flight Name: "+airline.getFlightName());
            System.out.println("Flight Number: "+airline.getFlightNumber());
            System.out.println("Destination: "+airline.getDestination());
            System.out.println("Departure date and time: "+airline.getDeparture());
            System.out.println("Arrival date and time: "+airline.getEstArrival());
            System.out.println("Gate Number: "+airline.getGateNum());
            System.out.println("Ticket Price: "+airline.getTicketPrice());
            System.out.println();
            counter++;
        }
    }

    public boolean displayAirlines(String flightName,String destination,float maxPrice) {
        int counter=0;
        boolean successful=Boolean.TRUE;
        for (Airline airline : airlines) {
            if(airline.getFlightName().equalsIgnoreCase(flightName) &&
                    airline.getDestination().equalsIgnoreCase(destination) &&airline.getTicketPrice()<=maxPrice){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();


            }
            else if(flightName.equals("")&&airline.getDestination().equalsIgnoreCase(destination)
                    &&airline.getTicketPrice()<=maxPrice){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();


            }
            else if(destination.equals("")&&airline.getFlightName().equalsIgnoreCase(flightName)&&airline.getTicketPrice()<=maxPrice){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();

            }
            else if(maxPrice==0&&airline.getFlightName().equalsIgnoreCase(flightName)&&airline.getDestination().equalsIgnoreCase(destination)){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();

            }
            else if(flightName.equals("")&&destination.equals("")
                    &&airline.getTicketPrice()<=maxPrice){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();

            }
            else if(flightName.equals("")&&airline.getDestination().equalsIgnoreCase(destination)
                    &&maxPrice==0){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();

            }
            else if(destination.equals("")&&airline.getFlightName().equalsIgnoreCase(flightName)
                    &&maxPrice==0){
                counter++;
                System.out.println(counter+". ");
                System.out.println("Flight Name: "+airline.getFlightName());
                System.out.println("Flight Number: "+airline.getFlightNumber());
                System.out.println("Destination: "+airline.getDestination());
                System.out.println("Departure date and time: "+airline.getDeparture());
                System.out.println("Arrival date and time: "+airline.getEstArrival());
                System.out.println("Gate Number: "+airline.getGateNum());
                System.out.println("Ticket Price: "+airline.getTicketPrice());
                System.out.println();

            }
            if(counter==0){
                successful=Boolean.FALSE;
            }
        }
        return successful;
    }

    public void buyTicket(Account account,Passenger passenger,Airline airline){
        if(account.getBalance()>=airline.getTicketPrice()){
            account.withDraw(airline.getTicketPrice());
            Ticket ticket=new Ticket(passenger.getFirstName(), passenger.getLastName(), passenger.getAge(),
                    passenger.getNationality(), airline.getFlightName(), airline.getFlightNumber(), airline.getDestination(),
                    airline.getDeparture(), airline.getEstArrival(), airline.getGateNum(),passenger.isCheckedIn(),
                    passenger.isImmigrationStamped(),passenger.getGender());
            airline.addPassengers(passenger);
            passenger.getMyTickets().add(ticket);
        }
        else{
            if(account.getBalance()<airline.getTicketPrice()&& airline.isFullCapacity()==Boolean.FALSE){
                System.out.println("Sorry you have insufficient funds. ");
            }
            else if(account.getBalance()<airline.getTicketPrice()&&airline.isFullCapacity()==Boolean.TRUE){
                System.out.println("The airline is already fully booked ");
            }
            else{
                System.out.println("Sorry you have insufficient funds and the airline is already fully booked ");
            }
        }

    }

    public ArrayList<Airline> getAirlineList(){
        return airlines;
    }

    public void immigration(Passenger passenger,Airline airline){

    }
}
