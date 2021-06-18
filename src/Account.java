public class Account extends Passenger{
    private float balance;

    //Class constructor
    public Account(String firstName, String lastName, int age, String nationality, boolean checkedIn, boolean immigrationStamped,
                   String gender,float balance ) {
        super(firstName, lastName, age, nationality, checkedIn, immigrationStamped, gender);
        this.balance=balance;
    }

    //get balance of account
    public float getBalance() {
        return balance;
    }

    //for putting money into the account
    public void deposit(float amt) {
        balance+=amt;
        System.out.println("Your current balance is: "+balance);
    }
    //withdraws if amount is equal or less than balance
    public void withDraw(float amt){
        if(amt<=balance){
            balance-=amt;

        }
    }
}
