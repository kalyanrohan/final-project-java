import java.time.LocalDateTime;
import java.util.ArrayList;

public class Airport {
    public String name;
    public String location;
    //array list to store airlines available in the airport
    public ArrayList<Airline> airlines=new ArrayList<>();

    //constructor
    public Airport(String Name,String Location){
        this.location=Location;
        this.name=Name;
    }

    //add airline to array list by getting all the necessary attributes which will be done throught the input
    //of users and then use those inputs to create a new airline. Once created then, add airline to the array list.
    public void addAirline(String airlineName, String flightNum, String Dest, LocalDateTime dep, LocalDateTime avl,int gateNumber,float ticketPrice){
        Airline airline=new Airline(airlineName,flightNum,Dest,dep,avl,gateNumber,ticketPrice);
        airlines.add(airline);
    }

    //iterate through the airlines array list and call the getters of the airline stored to get the details of each
    // airline in the airport
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

    // An overlaoded method which takes in flightName, destination and max price
    // This function will filter the airlines array list using the input given by the user and it will only display
    // those airlines that matches the criteria given by the user.
    public boolean displayAirlines(String flightName,String destination,float maxPrice) {
        int counter=0;
        //set boolean to TRUE
        boolean successful=Boolean.TRUE;
        for (Airline airline : airlines) {
            //if all three parameters are filled
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
            //if users skipped the flightname and entered destination and maxprice
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
            //if users skipped destination and entered flightname and maxprice
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
            //if users set maxprice as 0 (which means that they want to skip this) and users enter destination and flightname
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
            //if users only entered maxprice
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
            //if users only entered destination
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
            //if users only entered flightName
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
            //if the counter is 0, this means that none of the airlines in the array list matches any of the criteria
            // hence change to FALSE
            if(counter==0){
                successful=Boolean.FALSE;
            }
        }
        //if no airline matches the criteria given by the user, then successful becomes false. If found then it stays true
        return successful;
    }

    //buying ticket
    public void buyTicket(Account account,Passenger passenger,Airline airline){
        //check if have sufficient funds to do transaction and if airline is full or not
        if(account.getBalance()>=airline.getTicketPrice()&&airline.isFullCapacity()==Boolean.FALSE){
            //if have funds then withdraw money
            account.withDraw(airline.getTicketPrice());
            //create new ticket by using the passenger's getters as attributes for the constructor
            Ticket ticket=new Ticket(passenger.getFirstName(), passenger.getLastName(), passenger.getAge(),
                    passenger.getNationality(), airline.getFlightName(), airline.getFlightNumber(), airline.getDestination(),
                    airline.getDeparture(), airline.getEstArrival(), airline.getGateNum(),passenger.isCheckedIn(),
                    passenger.isImmigrationStamped(),passenger.getGender());
            //add passenger to the passenger list of the airline
            airline.addPassengers(passenger);
            //add ticket to the MyTickets array list
            passenger.getMyTickets().add(ticket);
        }
        //transaction can fail because of 2 things
        else{
            //not enough money
            if(account.getBalance()<airline.getTicketPrice()&& airline.isFullCapacity()==Boolean.FALSE){
                System.out.println("Sorry you have insufficient funds. ");
            }
            //airline already full
            else if(account.getBalance()<airline.getTicketPrice()&&airline.isFullCapacity()==Boolean.TRUE){
                System.out.println("The airline is already fully booked ");
            }
            //both
            else{
                System.out.println("Sorry you have insufficient funds and the airline is already fully booked ");
            }
        }

    }

    //get airline list
    public ArrayList<Airline> getAirlineList(){
        return airlines;
    }

}
