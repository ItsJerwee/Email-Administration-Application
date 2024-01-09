package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternativeEmail;

    Scanner input = new Scanner(System.in);

    public Email(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        System.out.println("New Employee: " + this.firstName + " " + this.lastName);
        this.password = this.generatePassword(10);
        this.email = this.generateEmail();
    }

    // Login email
    public void login() {
        System.out.print("----------\nEnter your email: ");
        String loginEmail = input.next();
        System.out.print("Enter your password: ");
        String loginPass = input.next();
        if (loginEmail.equals(this.email)) {
            if (loginPass.equals(this.password)) {
                System.out.println("Login sucessfully");
            } else {
                System.out.println("Password is wrong");
            }
        } else {
            System.out.println("Email is wrong");
        }
    }

    // Generate random password
    private String generatePassword(int length) {
        Random r = new Random();
        String numbers = "0123456789";
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "!@#$%^&*?";
        String passValues = numbers + capitalChars + chars + symbols;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(passValues.charAt(r.nextInt(passValues.length())));
        }
        return password.toString();
    }

    // Change department
    public void changeDepartment() {
        boolean b = false;
        do {
            System.out.println("----------\nDo you want to change your department? (Y/N)");
            char choice = input.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                b = true;
                System.out.println("Enter new department: ");
                this.department = input.next();
                System.out.println("Department changed successfully");
                this.email = this.generateEmail();
            } 
            else if (choice == 'N' || choice == 'n') {
                b = true;
                System.out.println("Option cancelled");
            } else {
                System.out.println("Enter a valid option");
            }
        
        } while (!b);
    }

    // Set password
    public void setPassword() {
        boolean b = false;
        do {
            System.out.println("Do you want to change your password? (Y/N)");
            char choice = input.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                b = true;
                System.out.println("Enter current password");
                String tempPass = input.next();
                if (tempPass.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = input.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect password");
                }
            } else if (choice == 'N' || choice == 'n') {
                b = true;
                System.out.println("Option cancelled");
            } else {
                System.out.println("Enter a valid option");
            }
        } while (!b);
    }

    // Change alternative email
    public void changeAlternativeEmail() {
        System.out.print("----------\nEnter new alternative email: ");
        this.alternativeEmail = input.next();
        System.out.println("Alternative email is set successfully");
    }
    
    // Generate email in firstname.lastname@department.company.com 
    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".company.com";
    }

    // Display info
    public void getInfo() {
        System.out.println("----------");
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Alternative email: " + this.alternativeEmail);
    }

    // Store data in file
    public void storeFile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\jerrylin\\Desktop\\info.txt");
            in.write("First name: " +  this.firstName);
            in.append("\nLast name: " + this.lastName);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nAlternative email: " + this.alternativeEmail);
            in.close();
            System.out.println("Data stored...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Read data from file
    public void readFile() {
        try {
            FileReader f1 = new FileReader("C:\\Users\\jerrylin\\Desktop\\info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char)i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
