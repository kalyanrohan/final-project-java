import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class driver {
    public static void main(String[] args){
        int choice;
        String firstname;
        String lastname;
        int age;
        String nationality;
        String gender;
        Airport ePort=new Airport("E-PORT","NEVER LAND");

        do {
            System.out.println("WELCOME TO E-PORT");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your first name: ");
            firstname=sc.nextLine();
            System.out.println("Please enter your last name: ");
            lastname=sc.nextLine();
            System.out.println("Enter your age: ");
            age=sc.nextInt();
            System.out.println("Enter your nationality: ");
            nationality=sc.nextLine();
            System.out.println("Enter your gender: ");
            gender=sc.nextLine();
            Passenger passenger=new Passenger(firstname,lastname,age,nationality,Boolean.FALSE,Boolean.FALSE,gender);
            Account account=new Account(firstname,lastname,age,nationality,Boolean.FALSE,Boolean.FALSE,gender,0);
            System.out.println("---E-PORT MENU---");
            System.out.println("1. BOOK A FLIGHT");
            System.out.println("2. IMMIGRATION");
            System.out.println("3. CHECK IN");
            System.out.println("4. BOARDING");
            System.out.println("5. LOGOUT/EXIT");
            choice=sc.nextInt();

            switch (choice){

                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;

            }
        }
        while(choice!=5);
        System.out.println("PROGRAM TERMINATED");
    }
}

