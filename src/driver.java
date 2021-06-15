import javax.lang.model.type.NullType;
import java.time.LocalDateTime;
import java.util.Scanner;

public class driver {
    public static void main(String[] args){
        int choice;
        int subChoice;
        String firstname;
        String lastname;
        int age;
        String nationality;
        String gender;
        Airport ePort=new Airport("E-PORT","JAKARTA");
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


        System.out.println("WELCOME TO E-PORT");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        firstname=sc.nextLine();
        System.out.println("Please enter your last name: ");
        lastname=sc.nextLine();
        System.out.println("Enter your age: ");
        age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your nationality: ");
        nationality=sc.nextLine();
        System.out.println("Enter your gender: ");
        gender=sc.nextLine();
        Passenger passenger=new Passenger(firstname,lastname,age,nationality,Boolean.FALSE,Boolean.FALSE,gender);
        Account account=new Account(firstname,lastname,age,nationality,Boolean.FALSE,Boolean.FALSE,gender,0);

        do {
            System.out.println("---E-PORT MENU---");
            System.out.println("1. BOOK A FLIGHT");
            System.out.println("2. IMMIGRATION");
            System.out.println("3. CHECK IN");
            System.out.println("4. DEPOSIT");
            System.out.println("5. ACCOUNT INFO");
            System.out.println("6. CANCEL BOOKING");
            System.out.println("7. EXIT/LOGOUT");
            System.out.println("array size: "+passenger.getMyTickets().size());
            System.out.println("array size: "+passenger.getTicketsIBought().size());
            System.out.println();
            choice=sc.nextInt();

            switch (choice){

                //buy ticket
                case 1:
                    int yesOrNo;
                    Passenger passenger1=new Passenger();
                    System.out.println("Are you purchasing a personal ticket?" +
                            "(if no, you will be filling a form for the person you are buying the ticket for.)\n"+
                            "1. Yes, I am purchasing a ticket for myself\n"+
                            "2. No, I am purchasing a ticket for someone else.\n"+
                            "Please enter either the number 1 or 2");
                    yesOrNo=sc.nextInt();
                    if(yesOrNo==1){
                        do {
                            System.out.println("BOOK A FLIGHT");
                            System.out.println("1. VIEW FLIGHTS");
                            System.out.println("2. CUSTOM SEARCH");
                            System.out.println("3. BACK");
                            subChoice=sc.nextInt();
                            switch (subChoice) {
                                case 1 -> {
                                    int chooseFlight;
                                    ePort.displayAirlines();
                                    System.out.println("Enter the number of desired flight: ");
                                    chooseFlight = sc.nextInt();
                                    ePort.buyTicket(account, passenger, ePort.getAirlineList().get(chooseFlight-1));

                                }
                                case 2 -> {
                                    String flightName;
                                    String destination;
                                    float maxPrice=0;
                                    Airline airline = new Airline();
                                    String flightNumber;
                                    System.out.println("Enter flight Name: ");
                                    flightName = sc.nextLine();
                                    sc.nextLine();
                                    System.out.println("Enter destination: ");
                                    destination = sc.nextLine();
                                    System.out.println("Enter max price: ");
                                    maxPrice = sc.nextFloat();
                                    sc.nextLine();
                                    if(ePort.displayAirlines(flightName, destination, maxPrice)==Boolean.FALSE) {
                                        System.out.println("sorry no flights found.");
                                        break;
                                    }
                                    System.out.println("Enter the FLIGHT NUMBER of desired flight: ");
                                    flightNumber = sc.nextLine();
                                    for (int i = 0; i < ePort.getAirlineList().size(); i++) {
                                        if (ePort.getAirlineList().get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                            airline = ePort.getAirlineList().get(i);
                                        }
                                    }
                                    if(airline==null){
                                        System.out.println("Sorry flight not found.");
                                        break;
                                    }
                                    ePort.buyTicket(account, passenger, airline);
                                }
                            }

                        }while(subChoice!=3);

                    }
                    else if(yesOrNo==2){
                        System.out.println("Please enter your first name: ");
                        sc.nextLine();
                        String firstname1 = sc.nextLine();
                        passenger1.setFirstName(firstname1);
                        System.out.println("Please enter your last name: ");
                        String lastname1 = sc.nextLine();
                        passenger1.setLastName(lastname1);
                        System.out.println("Enter your age: ");
                        int age1 = sc.nextInt();
                        sc.nextLine();
                        passenger1.setAge(age1);
                        System.out.println("Enter your nationality: ");
                        String nationality1 = sc.nextLine();
                        passenger1.setNationality(nationality1);
                        System.out.println("Enter your gender: ");
                        String gender1=sc.nextLine();
                        passenger1.setGender(gender1);
                        passenger1.setCheckedIn(Boolean.FALSE);
                        passenger1.setImmigrationStamped(Boolean.FALSE);

                        do {
                            System.out.println("BOOK A FLIGHT");
                            System.out.println("1. VIEW FLIGHTS");
                            System.out.println("2. CUSTOM SEARCH");
                            System.out.println("3. BACK");
                            subChoice=sc.nextInt();
                            switch (subChoice) {
                                case 1 -> {
                                    int chooseFlight;
                                    ePort.displayAirlines();
                                    System.out.println("Enter the number of desired flight: ");
                                    chooseFlight = sc.nextInt();
                                    ePort.buyTicket(account, passenger1, ePort.getAirlineList().get(chooseFlight-1));
                                    if(passenger1.getMyTickets().size()!=0){
                                        passenger1.getTicketDetails();
                                        System.out.println("Purchase successful!");
                                        for(int i=0;i<passenger1.getMyTickets().size();i++){
                                            passenger.getTicketsIBought().add(passenger1);
                                            System.out.println("array size: "+passenger.getTicketsIBought().size());
                                        }
                                    }
                                    else{
                                        break;
                                    }

                                }
                                case 2 -> {
                                    String flightName;
                                    String destination;
                                    float maxPrice=0;
                                    Airline airline = new Airline();
                                    String flightNumber;
                                    System.out.println("Enter flight Name: ");
                                    flightName = sc.nextLine();
                                    sc.nextLine();
                                    System.out.println("Enter destination: ");
                                    destination = sc.nextLine();
                                    System.out.println("Enter max price: ");
                                    maxPrice = sc.nextFloat();
                                    if(ePort.displayAirlines(flightName, destination, maxPrice)==Boolean.FALSE) {
                                        System.out.println("sorry no flights found.");
                                        break;
                                    }
                                    System.out.println("Enter the flight number of desired flight: ");
                                    flightNumber = sc.nextLine();
                                    sc.nextLine();
                                    for (int i = 0; i < ePort.getAirlineList().size(); i++) {
                                        if (ePort.getAirlineList().get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                            airline = ePort.getAirlineList().get(i);
                                        } else {
                                            System.out.println("Sorry flight not found.");
                                        }
                                    }
                                    ePort.buyTicket(account, passenger, airline);
                                    if(passenger1.getMyTickets().size()!=0){
                                        passenger1.getTicketDetails();
                                        System.out.println("Purchase successful!");
                                        for(int i=0;i<passenger1.getMyTickets().size();i++){
                                            passenger.getTicketsIBought().add(passenger1);

                                        }
                                    }
                                    else{
                                        break;
                                    }
                                }
                            }

                        }while(subChoice!=3);
                    }
                    break;
                case 2:
                    System.out.println("Which ticket do you want to check in with?");
                    break;
                case 3:
                    break;
                case 4:
                    float amt;
                    System.out.println("Enter deposit amount: ");
                    amt=sc.nextFloat();
                    account.deposit(amt);
                    break;
                case 5:
                    System.out.println("Here are your account details: ");
                    passenger.getDetails();
                    System.out.println("Your balance in your account is: "+account.getBalance());
                    System.out.println();
                    System.out.println("Ticket Details: ");
                    passenger.getTicketDetails();
                    System.out.println("Tickets I bought: ");
                    for(int i=0;i<passenger.getTicketsIBought().size();i++){
                        passenger.getTicketsIBought().get(i).getTicketDetails();
                    }
                    break;
                case 6:
                    int subChoice1;
                    if(passenger.getMyTickets().size()==0&&passenger.getTicketsIBought().size()==0){
                        System.out.println("Sorry you have not purchased any tickets");
                        break;
                    }
                    if(passenger.isCheckedIn()==Boolean.TRUE){
                        System.out.println("Refund is not available because you have checked in.");
                        break;
                    }
                    System.out.println("Confirm cancellation of booking: ");
                    System.out.println("1. I want to cancel my own ticket.");
                    System.out.println("2. I want to cancel a ticket that I bought for someone else. ");
                    System.out.println("3. Back");
                    subChoice1=sc.nextInt();
                    sc.nextLine();
                    if (subChoice1==1){
                        passenger.getTicketDetails();
                        System.out.println("Enter flight number of the ticket to be cancelled: ");
                        String flightNumber;
                        flightNumber=sc.nextLine();
                        for(int i=0;i<passenger.getMyTickets().size();i++){
                            if(passenger.getMyTickets().get(i).getFlightNumber().equalsIgnoreCase(flightNumber)){
                                passenger.getMyTickets().remove(passenger.getMyTickets().get(i));
                            }
                            else{
                                System.out.println("Ticket not found.");
                                break;
                            }
                        }
                        for(int j=0;j<ePort.getAirlineList().size();j++){
                            if(flightNumber.equalsIgnoreCase(ePort.getAirlineList().get(j).getFlightNumber())){
                                ePort.getAirlineList().get(j).getPassengerList().remove(passenger.getFirstName()+" "+passenger.getLastName());
                                account.deposit(ePort.getAirlineList().get(j).getTicketPrice());
                            }

                        }
                    }
                    else if(subChoice1==2){
                        for(int i=0;i<passenger.getTicketsIBought().size();i++){
                            passenger.getTicketsIBought().get(i).getTicketDetails();
                        }
                        String flightNumber;
                        String firstname1;
                        String lastname1;
                        System.out.println("Enter flight number of the ticket to be cancelled: ");
                        flightNumber=sc.nextLine();
                        System.out.println("Enter first name of passenger: ");
                        firstname1=sc.nextLine();
                        System.out.println("Enter last name of passenger: ");
                        lastname1=sc.nextLine();
                        System.out.println(firstname1+lastname1+flightNumber);

                        System.out.println(passenger.getTicketsIBought().size());
                        for(int i=0;i<passenger.getTicketsIBought().size();i++){
                            try {
                                System.out.println(passenger.getTicketsIBought().get(i).getFirstName());
                                System.out.println(passenger.getTicketsIBought().get(i).getLastName());
                                if(passenger.getTicketsIBought().get(i).getMyTickets().get(0).getFlightNumber().equalsIgnoreCase(flightNumber)
                                &&firstname1.equalsIgnoreCase(passenger.getTicketsIBought().get(i).getFirstName())
                                        &&lastname1.equalsIgnoreCase(passenger.getTicketsIBought().get(i).getLastName()))
                                {
                                    passenger.getTicketsIBought().remove(passenger.getTicketsIBought().get(i));
                                    for(int j=0;j<ePort.getAirlineList().size();j++){
                                        if(flightNumber.equalsIgnoreCase(ePort.getAirlineList().get(j).getFlightNumber())){
                                            ePort.getAirlineList().get(j).getPassengerList().remove(passenger.getTicketsIBought().get(i).getFirstName()+" "+passenger.getTicketsIBought().get(i).getLastName());
                                            account.deposit(ePort.getAirlineList().get(j).getTicketPrice());
                                        }

                                    }
                                }
                            }catch (IndexOutOfBoundsException ignored){

                            }

                        }

                    }
            }
        }
        while(choice!=7);
        System.out.println("PROGRAM TERMINATED");
    }
}

