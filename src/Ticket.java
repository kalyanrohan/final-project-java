import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ticket extends Passenger implements Details{
    private String TairlineName;
    private String TflightNumber;
    private String TDestination;
    private LocalDateTime Tdeparture;
    private LocalDateTime TestArrival;
    private int TgateNum;
    private String TseatType;
    private int TseatNum;

    public Ticket(String firstName, String lastName, int age, String nationality, String airlineName,String flightNumber,
                  String Destination,LocalDateTime departure, LocalDateTime estArrival,int gateNum,boolean checkedIn,boolean immigrationStamped,
                  String seatType, int seatNum, String gender) {
        super(firstName, lastName, age, nationality,checkedIn,immigrationStamped,gender);
        this.TairlineName=airlineName;
        this.TflightNumber=flightNumber;
        this.TseatNum=seatNum;
        this.TseatType=seatType;
        this.TDestination=Destination;
        this.Tdeparture=departure;
        this.TestArrival=estArrival;
        this.TgateNum=gateNum;
    }
    //getters


    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    public String getFlightName() {
        return TairlineName;
    }

    public String getFlightNumber() {
        return TflightNumber;
    }

    public int getTseatNum() {
        return TseatNum;
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

    public String getTseatType() {
        return TseatType;
    }

    public int getGateNum() {
        return TgateNum;
    }


    //setters


    public void setTairlineName(Airline airlineName) {
        this.TairlineName = airlineName.getFlightName();
    }

    public void setTflightNumber(Airline flightNumber) {
        this.TflightNumber = flightNumber.getFlightNumber();
    }

    public void setTdeparture(Airline departure) {
        this.Tdeparture = departure.getDeparture();
    }

    public void setTDestination(Airline Destination) {
        this.TDestination = Destination.getDestination();
    }

    public void setTestArrival(Airline estArrival) {
        this.TestArrival = estArrival.getEstArrival();
    }

    public void setTgateNum(Airline gateNum) {
        this.TgateNum = gateNum.getGateNum();
    }

    public void setTseatType(String tseatType) {
        this.TseatType = tseatType;
    }

    public void setTseatNum(int tseatNum) {
        this.TseatNum = tseatNum;
    }


}


