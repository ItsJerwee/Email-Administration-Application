package emailapp;

import java.util.Scanner;

public class Main {
  
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = input.next();
        System.out.print("Enter your last name: ");
        String lastName = input.next();
        System.out.print("Enter your department: ");
        String department = input.next();

        Email email1 = new Email(firstName, lastName, department);
        int option = 0;
        do {
            System.out.println("----------\nEnter your choice\n1. Show Info\n2. Login\n3. Change password\n4. Change department\n5. Set Alternative mail\n6. Store data in file\n7. Show data from file\n8. Exit");
            option = input.nextInt();
            switch (option) {
                case 1: 
                    email1.getInfo();
                    break;
                case 2:
                    email1.login();
                    break;
                case 3: 
                    email1.setPassword();
                    break;
                case 4: 
                    email1.changeDepartment();
                    break;
                case 5: 
                    email1.changeAlternativeEmail();
                    break;
                case 6: 
                    email1.storeFile();
                    break;
                case 7:
                    email1.readFile();
                    break;
                case 8:
                    System.out.println("----------\nThank you for using the application");
                    return;
                default:
                    System.out.println("----------\nInvalid option!\nEnter valid option");
            }
        } while (option != 5);

        input.close();
    }
    
}
