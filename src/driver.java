import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class driver {
    public static void main(String[] args){
        //initializing all required variables
        int choice;
        int subChoice;
        int val;
        int numPut = 0;
        String firstname;
        String lastname;
        int age;
        String nationality;
        String gender;
        //using scanner for user input
        Scanner sc = new Scanner(System.in);
        //creating airport object
        Airport ePort=new Airport("E-PORT","JAKARTA");
        //adding airlines to airline array list in airport object
        ePort.addAirline("AIRMAX","AMX023","Bali",
                LocalDateTime.of(2021,10,15,12,15),
                LocalDateTime.of(2021,10,15,15,15),1,100);
        ePort.addAirline("AIRMAX","AMX025","Paris",
                LocalDateTime.of(2021,10,15,12,15),
                LocalDateTime.of(2021,10,15,23,15),2,210);
        ePort.addAirline("AIRJORDAN","AJD025","Tokyo",
                LocalDateTime.of(2021,10,15,12,15),
                LocalDateTime.of(2021,10,15,19,15),3,180);
        ePort.addAirline("AIRJORDAN","AJD023","Bali",
                LocalDateTime.of(2021,10,15,15,15),
                LocalDateTime.of(2021,10,15,18,15),2,120);
        ePort.addAirline("AIRFORCE","AFE237","London",
                LocalDateTime.of(2021,10,15,12,15),
                LocalDateTime.of(2021,10,15,20,15),4,180);
        ePort.addAirline("AIRFORCE","AFE190","New York",
                LocalDateTime.of(2021,10,15,12,15),
                LocalDateTime.of(2021,10,16,8,15),5,250);

        //user sign up
        System.out.println("WELCOME TO E-PORT");
        System.out.println("Please enter your first name: ");
        firstname=sc.nextLine();
        System.out.println("Please enter your last name: ");
        lastname=sc.nextLine();
        //using a do-while loop and try/catch to make sure users input an integer
        do {
            sc.nextLine();
            try {
                System.out.println("Enter your age: ");
                numPut=sc.nextInt();
                val=0;
            //this will catch any non-integer input and make val==1 so that it keeps looping until correct input is made
            }catch (InputMismatchException e){
                val=1;
                System.out.println("Please enter an integer.");
            }
        }while (val==1);
        age=numPut;
        sc.nextLine();
        System.out.println("Enter your nationality: ");
        nationality=sc.nextLine();
        System.out.println("Enter your gender(male/female): ");
        gender=sc.nextLine();
        //creating passenger object using the inputs
        Passenger passenger=new Passenger(firstname,lastname,age,nationality,Boolean.FALSE,Boolean.FALSE,gender);
        //creating account object and initializing balance to 0
        Account account=new Account(firstname,lastname,age,nationality,Boolean.FALSE,Boolean.FALSE,gender,0);

        //using do-while loop to create menus
        do {
            //MAIN MENU
            System.out.println("---E-PORT MENU---");
            System.out.println("1. BOOK A FLIGHT");
            System.out.println("2. CHECK IN/IMMIGRATION");
            System.out.println("3. DEPOSIT");
            System.out.println("4. ACCOUNT INFO");
            System.out.println("5. CANCEL BOOKING");
            System.out.println("6. EXIT/LOGOUT");
            System.out.println();
            //taking user input for navigating the menu
            choice=sc.nextInt();

            switch (choice) {
                //buying tickets
                case 1 -> {
                    int yesOrNo;
                    ///initializing new passenger object
                    Passenger passenger1 = new Passenger();
                    //asking user whether they want to buy a ticket for themselves or for someone else
                    System.out.println("""
                            Are you purchasing a personal ticket?(if no, you will be filling a form for the person you are buying the ticket for.)
                            1. Yes, I am purchasing a ticket for myself
                            2. No, I am purchasing a ticket for someone else.
                            Please enter either the number 1 or 2""");
                    yesOrNo = sc.nextInt();
                    if (yesOrNo == 1) {
                        //creating a sub menu
                        do {
                            System.out.println("BOOK A FLIGHT");
                            System.out.println("1. VIEW FLIGHTS");
                            System.out.println("2. CUSTOM SEARCH");
                            System.out.println("3. BACK");
                            subChoice = sc.nextInt();
                            switch (subChoice) {
                                //displaying all available flights
                                case 1 -> {
                                    int chooseFlight;
                                    //calling the display function from the airport class
                                    ePort.displayAirlines();
                                    int subChoice3;
                                    //confirming with user whether they want to make a transaction
                                    System.out.println("1.Choose flight");
                                    System.out.println("2.Back");
                                    subChoice3 = sc.nextInt();
                                    if (subChoice3 == 2) {
                                        break;
                                    }
                                    //having users pick their flights
                                    System.out.println("Enter the number of desired flight: ");
                                    chooseFlight = sc.nextInt();
                                    //calling the buyTicket function from the airport class
                                    //since the flights are stored in an array, I decremented the chooseFlight variable
                                    //by 1 since indices starts at 0
                                    ePort.buyTicket(account, passenger, ePort.getAirlineList().get(chooseFlight - 1));
                                    if (passenger.getMyTickets().size() != 0) {
                                        passenger.getTicketDetails();
                                        System.out.println("Purchase successful!");
                                    }
                                    System.out.println("Your remaining balance: "+account.getBalance());

                                }
                                //custom search
                                case 2 -> {
                                    //initialize local variables
                                    String flightName;
                                    String destination;
                                    float maxPrice;
                                    int subChoice3;
                                    //initializing new airline so that we can equalize it with the search result
                                    Airline airline = new Airline();
                                    //entering the necessary details for the custom search
                                    String flightNumber;
                                    System.out.println("Enter flight Name: ");
                                    sc.nextLine();
                                    flightName = sc.nextLine();
                                    System.out.println("Enter destination: ");
                                    destination = sc.nextLine();
                                    System.out.println("Enter max price (enter 0 to skip): ");
                                    maxPrice = sc.nextFloat();
                                    sc.nextLine();
                                    //calling the display function but this time overloading with the inputs
                                    //if the function return false it means that no airline is found, hence we break
                                    if (ePort.displayAirlines(flightName, destination, maxPrice) == Boolean.FALSE) {
                                        System.out.println("sorry no flights found.");
                                        break;
                                    }
                                    //confirming user for transaction
                                    System.out.println("1.Choose flight");
                                    System.out.println("2.Back");
                                    subChoice3 = sc.nextInt();
                                    if (subChoice3 == 2) {
                                        break;
                                    }
                                    sc.nextLine();
                                    //instead of entering the number when the airlines are displayed
                                    //users will input the flight number of their desired airline as they are unique
                                    System.out.println("Enter the FLIGHT NUMBER of desired flight: ");
                                    flightNumber = sc.nextLine();
                                    for (int i = 0; i < ePort.getAirlineList().size(); i++) {
                                        //equating airline with the airline found
                                        if (ePort.getAirlineList().get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                            airline = ePort.getAirlineList().get(i);
                                        }
                                    }
                                    //if airline is still null, this means that no airlines are found
                                    if (airline == null) {
                                        System.out.println("Sorry flight not found.");
                                        break;
                                    }
                                    //call the buyTicket function
                                    ePort.buyTicket(account, passenger, airline);
                                    if (passenger.getMyTickets().size() != 0) {
                                        passenger.getTicketDetails();
                                        System.out.println("Purchase successful!");
                                    }
                                    System.out.println("Your remaining balance: "+account.getBalance());
                                }
                            }

                        } while (subChoice != 3);
                    //called if user want to buy ticket for someone else
                    } else if (yesOrNo == 2) {
                        //inputs details
                        // calling the setters to set the attributes of the new passenger object with the inputs
                        System.out.println("Please enter your first name: ");
                        sc.nextLine();
                        String firstname1 = sc.nextLine();
                        passenger1.setFirstName(firstname1);
                        System.out.println("Please enter your last name: ");
                        String lastname1 = sc.nextLine();
                        passenger1.setLastName(lastname1);
                        //using a do-while loop and try/catch to make sure users input an integer
                        do {
                            sc.nextLine();
                            try {
                                System.out.println("Enter your age: ");
                                numPut=sc.nextInt();
                                val=0;
                                //this will catch any non-integer input and make val==1 so that it keeps looping until correct input is made
                            }catch (InputMismatchException e){
                                val=1;
                                System.out.println("Please enter an integer.");
                            }
                        }while (val==1);
                        int age1=numPut;
                        sc.nextLine();
                        passenger1.setAge(age1);
                        System.out.println("Enter your nationality: ");
                        String nationality1 = sc.nextLine();
                        passenger1.setNationality(nationality1);
                        System.out.println("Enter your gender: ");
                        String gender1 = sc.nextLine();
                        passenger1.setGender(gender1);
                        passenger1.setCheckedIn(Boolean.FALSE);
                        passenger1.setImmigrationStamped(Boolean.FALSE);

                        //call the submenu
                        do {
                            System.out.println("BOOK A FLIGHT");
                            System.out.println("1. VIEW FLIGHTS");
                            System.out.println("2. CUSTOM SEARCH");
                            System.out.println("3. BACK");
                            subChoice = sc.nextInt();
                            switch (subChoice) {
                                //displaying all the flights
                                case 1 -> {
                                    int chooseFlight;
                                    //calling display function
                                    ePort.displayAirlines();
                                    int subChoice3;
                                    //confirming with user
                                    System.out.println("1.Choose flight");
                                    System.out.println("2.Back");
                                    subChoice3 = sc.nextInt();
                                    if (subChoice3 == 2) {
                                        break;
                                    }
                                    System.out.println("Enter the number of desired flight: ");
                                    chooseFlight = sc.nextInt();
                                    //calling the buy function by using passenger1 object
                                    ePort.buyTicket(account, passenger1, ePort.getAirlineList().get(chooseFlight - 1));
                                    //if the length of the array is not 0, this means that a ticket is added
                                    //which means that the purchase was successful
                                    if (passenger1.getMyTickets().size() != 0) {
                                        passenger1.getTicketDetails();
                                        System.out.println("Purchase successful!");
                                        //add passenger1 to the array of the tickets that passenger bought
                                        for (int i = 0; i < passenger1.getMyTickets().size(); i++) {
                                            passenger.getTicketsIBought().add(passenger1);
                                        }
                                    }
                                    System.out.println("Your remaining balance: "+account.getBalance());

                                }
                                //using custom search
                                case 2 -> {
                                    //initialize local variables
                                    String flightName;
                                    String destination;
                                    float maxPrice;
                                    int subChoice3;
                                    //initializing new airline so that we can equalize it with the search result
                                    Airline airline = new Airline();
                                    //entering the necessary details for the custom search
                                    String flightNumber;
                                    System.out.println("Enter flight Name: ");
                                    sc.nextLine();
                                    flightName = sc.nextLine();
                                    System.out.println("Enter destination: ");
                                    destination = sc.nextLine();
                                    System.out.println("Enter max price (enter 0 to skip): ");
                                    maxPrice = sc.nextFloat();
                                    sc.nextLine();
                                    //calling the display function but this time overloading with the inputs
                                    //if the function return false it means that no airline is found, hence we break
                                    if (ePort.displayAirlines(flightName, destination, maxPrice) == Boolean.FALSE) {
                                        System.out.println("sorry no flights found.");
                                        break;
                                    }
                                    //confirming user for transaction
                                    System.out.println("1.Choose flight");
                                    System.out.println("2.Back");
                                    subChoice3 = sc.nextInt();
                                    if (subChoice3 == 2) {
                                        break;
                                    }
                                    sc.nextLine();
                                    //instead of entering the number when the airlines are displayed
                                    //users will input the flight number of their desired airline as they are unique
                                    System.out.println("Enter the FLIGHT NUMBER of desired flight: ");
                                    flightNumber = sc.nextLine();
                                    for (int i = 0; i < ePort.getAirlineList().size(); i++) {
                                        //equating airline with the airline found
                                        if (ePort.getAirlineList().get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                            airline = ePort.getAirlineList().get(i);
                                        }
                                    }
                                    //if airline is still null, this means that no airlines are found
                                    if (airline == null) {
                                        System.out.println("Sorry flight not found.");
                                        break;
                                    }
                                    //call the buyTicket function
                                    ePort.buyTicket(account, passenger1, airline);
                                    //if array of tickets is 0, the purchase failed but if array is more than 0, this
                                    //means that purchase is successful
                                    if (passenger1.getMyTickets().size() != 0) {
                                        passenger1.getTicketDetails();
                                        System.out.println("Purchase successful!");
                                        //append passenger1 to the array of tickets that passenger bought
                                        for (int i = 0; i < passenger1.getMyTickets().size(); i++) {
                                            passenger.getTicketsIBought().add(passenger1);
                                        }
                                    }
                                    System.out.println("Your remaining balance: "+account.getBalance());
                                }
                            }

                        } while (subChoice != 3);
                    }
                }
                //CHECK IN AND IMMIGRATION
                case 2 -> {
                    //check if passenger have tickets
                    if (passenger.getMyTickets().size() == 0) {
                        System.out.println("You have not purchased any tickets");
                        break;
                    }
                    //display ticket details and confirm check in
                    passenger.getTicketDetails();
                    System.out.println("Confirm check in?");
                    System.out.println("1. Yes I want to confirm.");
                    System.out.println("2. Back");
                    int choice2;
                    choice2 = sc.nextInt();
                    //change the checkedIn and Immigration attribute to True
                    if (choice2 == 1) {
                        passenger.setCheckedIn(Boolean.TRUE);
                        passenger.setImmigrationStamped(Boolean.TRUE);
                    }
                }
                //Deposit
                case 3 -> {
                    float amt;
                    System.out.println("Enter deposit amount: ");
                    amt = sc.nextFloat();
                    //call the deposit function from the account class
                    account.deposit(amt);
                }
                //showing account info
                case 4 -> {
                    System.out.println("Here are your account details: ");
                    //get details of passenger such as name, age and etc.
                    passenger.getDetails();
                    //for showing account balance
                    System.out.println("Your balance in your account is: " + account.getBalance());
                    System.out.println();
                    System.out.println("My Ticket Details: ");
                    //get details of users own ticket which includes flightName,flightNumber,Destination and etc.
                    passenger.getTicketDetails();
                    System.out.println("Other Tickets I bought: ");
                    //get tickets that were bought for someone else and calling the get ticket details to get the details
                    // of every ticket
                    for (int i = 0; i < passenger.getTicketsIBought().size(); i++) {
                        passenger.getTicketsIBought().get(i).getTicketDetails();
                    }
                }
                //cancelling tickets
                case 5 -> {
                    int subChoice1;
                    //check if passenger has bought any tickets
                    if (passenger.getMyTickets().size() == 0 && passenger.getTicketsIBought().size() == 0) {
                        System.out.println("Sorry you have not purchased any tickets");
                        break;
                    }
                    //ask whether they want to cancel their own tickets or the tickets that they bought for someone else
                    System.out.println("Confirm cancellation of booking: ");
                    System.out.println("1. I want to cancel my own ticket.");
                    System.out.println("2. I want to cancel a ticket that I bought for someone else. ");
                    System.out.println("3. Back");
                    subChoice1 = sc.nextInt();
                    sc.nextLine();
                    //cancelling users own ticket
                    if (subChoice1 == 1) {
                        //check whether passenger has checked in, if yes then refund is not possible
                        if (passenger.isCheckedIn() == Boolean.TRUE) {
                            System.out.println("Refund is not available because you have checked in.");
                            break;
                        }
                        //show ticket details
                        passenger.getTicketDetails();
                        //user enters the flight number stated on their tickets to confirm cancellation
                        System.out.println("Enter flight number of the ticket to be cancelled: ");
                        String flightNumber;
                        flightNumber = sc.nextLine();
                        //loops through the array of myTickets to check whether any tickets match the inputted flight
                        //number. If no match then print out else statement. If found then remove the ticket from the
                        //array
                        for (int i = 0; i < passenger.getMyTickets().size(); i++) {
                            if (passenger.getMyTickets().get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                passenger.getMyTickets().remove(passenger.getMyTickets().get(i));
                            } else {
                                System.out.println("Ticket not found.");
                                break;
                            }
                        }
                        //loop through the array that stores the airlines and check if the inputted flight number
                        // matches the flight number inputted by the user. When found,remove passenger from the
                        //passenger list array of the airline object and then refund money by using the deposit
                        //function to the account
                        for (int j = 0; j < ePort.getAirlineList().size(); j++) {
                            if (flightNumber.equalsIgnoreCase(ePort.getAirlineList().get(j).getFlightNumber())) {
                                ePort.getAirlineList().get(j).getPassengerList().remove(passenger.getFirstName() + " " + passenger.getLastName());
                                account.deposit(ePort.getAirlineList().get(j).getTicketPrice());
                            }

                        }
                    //cancelling other tickets
                    } else if (subChoice1 == 2) {
                        //show all the tickets bought for other people
                        for (int i = 0; i < passenger.getTicketsIBought().size(); i++) {
                            passenger.getTicketsIBought().get(i).getTicketDetails();
                        }
                        //get input
                        String flightNumber;
                        String firstname1;
                        String lastname1;
                        System.out.println("Enter flight number of the ticket to be cancelled: ");
                        flightNumber = sc.nextLine();
                        System.out.println("Enter first name of passenger: ");
                        firstname1 = sc.nextLine();
                        System.out.println("Enter last name of passenger: ");
                        lastname1 = sc.nextLine();
                        //looping through the array of tickets bought for other people
                        for (int i = 0; i < passenger.getTicketsIBought().size(); i++) {
                            //finding the ticket that matches the first and last name inputted and flight number
                            //if found then remove from array
                            if (passenger.getTicketsIBought().get(i).getMyTickets().get(0).getFlightNumber().equalsIgnoreCase(flightNumber)
                                    && firstname1.equalsIgnoreCase(passenger.getTicketsIBought().get(i).getFirstName())
                                    && lastname1.equalsIgnoreCase(passenger.getTicketsIBought().get(i).getLastName())) {
                                passenger.getTicketsIBought().remove(passenger.getTicketsIBought().get(i));
                                }
                            }
                        //loop through the array that stores the airlines and check if the inputted flight number
                        // matches the flight number inputted by the user. When found,remove passenger from the
                        //passenger list array of the airline object and then refund money by using the deposit
                        //function to the account
                        for (int j = 0; j < ePort.getAirlineList().size(); j++) {
                            if (flightNumber.equalsIgnoreCase(ePort.getAirlineList().get(j).getFlightNumber())) {
                                ePort.getAirlineList().get(j).getPassengerList().remove(firstname1+" "+lastname1);
                                account.deposit(ePort.getAirlineList().get(j).getTicketPrice());
                            }
                        }
                    }
                }
            }
        }
        //if choice becomes 6 then end the program
        while(choice!=6);
        System.out.println("THANK YOU FOR USING OUR SERVICE");
    }
}

