import java.time.LocalDateTime;

public class Ticket extends Passenger implements Details{
    private String TairlineName;
    private String TflightNumber;
    private String TDestination;
    private LocalDateTime Tdeparture;
    private LocalDateTime TestArrival;
    private int TgateNum;

    //constructor
    public Ticket(String firstName, String lastName, int age, String nationality, String airlineName,String flightNumber,
                  String Destination,LocalDateTime departure, LocalDateTime estArrival,int gateNum,boolean checkedIn,boolean immigrationStamped, String gender) {
        super(firstName, lastName, age, nationality,checkedIn,immigrationStamped,gender);
        this.TairlineName=airlineName;
        this.TflightNumber=flightNumber;
        this.TDestination=Destination;
        this.Tdeparture=departure;
        this.TestArrival=estArrival;
        this.TgateNum=gateNum;
    }

    //getters

    public String getFlightName() {
        return TairlineName;
    }

    public String getFlightNumber() {
        return TflightNumber;
    }

    public LocalDateTime getDeparture() {
        return Tdeparture;
    }

    public LocalDateTime getEstArrival() {
        return TestArrival;
    }

    public String getDestination() {
        return TDestination;
    }


    public int getGateNum() {
        return TgateNum;
    }


}


