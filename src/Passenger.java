import java.time.LocalTime;
import java.util.ArrayList;

public class Passenger  {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String nationality;
    private boolean checkedIn;
    private boolean immigrationStamped;
    private ArrayList<Ticket>myTickets=new ArrayList<>();
    private ArrayList<Passenger>TicketsIBought=new ArrayList<>();

    public Passenger(String firstName,String lastName,int age, String nationality,boolean checkedIn,boolean immigrationStamped,String gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.age=age;
        this.nationality=nationality;
        this.checkedIn=checkedIn;
        this.immigrationStamped=immigrationStamped;
    }

    public Passenger(){
    }


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

    public void getDetails(){
        System.out.println("First Name: "+getFirstName());
        System.out.println("Last Name: "+getLastName());
        System.out.println("Age: "+getAge());
        System.out.println("Gender: "+getGender());
        System.out.println("Nationality: "+getNationality());
        System.out.println();
    }

    public boolean isImmigrationStamped() {
        return immigrationStamped;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

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

    public void addTicket(Ticket ticket){
        myTickets.add(ticket);
    }

    public ArrayList<Ticket> getMyTickets() {
        return myTickets;
    }

    public ArrayList<Passenger> getTicketsIBought() {
        return TicketsIBought;
    }

}
