import java.util.ArrayList;

public class Passenger  {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String nationality;
    private boolean checkedIn;
    private boolean immigrationStamped;
    //array list to store own tickets
    private ArrayList<Ticket>myTickets=new ArrayList<>();
    //array list to store tickets that are bought for someone else
    private ArrayList<Passenger>TicketsIBought=new ArrayList<>();

    //constructor
    public Passenger(String firstName,String lastName,int age, String nationality,boolean checkedIn,boolean immigrationStamped,String gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.age=age;
        this.nationality=nationality;
        this.checkedIn=checkedIn;
        this.immigrationStamped=immigrationStamped;
    }
    //default constructor
    public Passenger(){
    }

    //getters overriding the interface
    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }

    //unique getters that are not from the interface
    public boolean isImmigrationStamped() {
        return immigrationStamped;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public ArrayList<Ticket> getMyTickets() {
        return myTickets;
    }

    public ArrayList<Passenger> getTicketsIBought() {
        return TicketsIBought;
    }

    //looping through the myTickets array and printing out every detail the ticket has
    public void getTicketDetails(){
        for (Ticket myTicket : myTickets) {
            System.out.println("First Name: " + getFirstName());
            System.out.println("Last Name: " + getLastName());
            System.out.println("Age: " + getAge());
            System.out.println("Gender: " + getGender());
            System.out.println("Nationality: " + getNationality());
            System.out.println();
            System.out.println("Flight Name: " + myTicket.getFlightName());
            System.out.println("Flight Number: " + myTicket.getFlightNumber());
            System.out.println("Destination: " + myTicket.getDestination());
            System.out.println("Departure date and time: " + myTicket.getDeparture());
            System.out.println("Arrival date and time: " + myTicket.getEstArrival());
            System.out.println("Gate Number: " + myTicket.getGateNum());
            System.out.println();
        }
    }

    //get details of passenger only
    public void getDetails(){
        System.out.println("First Name: "+getFirstName());
        System.out.println("Last Name: "+getLastName());
        System.out.println("Age: "+getAge());
        System.out.println("Gender: "+getGender());
        System.out.println("Nationality: "+getNationality());
        System.out.println();
    }
    //setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public void setImmigrationStamped(boolean immigrationStamped) {
        this.immigrationStamped = immigrationStamped;
    }

}