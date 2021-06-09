import java.time.LocalTime;

public class Passenger  {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String nationality;
    private boolean checkedIn;
    private boolean immigrationStamped;

    public Passenger(String firstName,String lastName,int age, String nationality,boolean checkedIn,boolean immigrationStamped,String gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.age=age;
        this.nationality=nationality;
        this.checkedIn=checkedIn;
        this.immigrationStamped=immigrationStamped;
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

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public void setImmigrationStamped(boolean immigrationStamped) {
        this.immigrationStamped = immigrationStamped;
    }

}
