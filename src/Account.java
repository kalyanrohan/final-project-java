public class Account extends Passenger{
    private float balance;

    public Account(String firstName, String lastName, int age, String nationality, boolean checkedIn, boolean immigrationStamped,
                   String gender,float balance ) {
        super(firstName, lastName, age, nationality, checkedIn, immigrationStamped, gender);
        this.balance=balance;
    }


    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    public float getBalance() {
        return balance;
    }

    public void deposit(float amt) {
        balance+=amt;
        System.out.println("Your current balance is: "+balance);
    }

    public boolean withDraw(float amt){
        boolean successful=Boolean.FALSE;
        if(amt<=balance){
            balance-=amt;
            successful=Boolean.TRUE;
        }
        return successful;
    }
}
