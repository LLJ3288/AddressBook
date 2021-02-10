package com.tts;


import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        displayMenu();
        //findEmail();
        //printBook();
    }

    public static void saveContact(String Firstname, String Lastname, long number, String email) {
        System.out.println("Contact Saved: " + Firstname + " " + Lastname + " : " + number + " : " + email);

        try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true))) {
            pw.println(Firstname + " " + Lastname + " : " + number + " : " + email);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }



//    public static void removeContact(String s) throws IOException {
//
//        File file = new File("file.txt");
//        File temp = new File("_temp_");
//        PrintWriter out = new PrintWriter(new FileWriter(temp));
//        Files.lines(file.toPath())
//                .filter(line -> !line.contains(s))
//                .forEach(out::println);
//        out.flush();
//        out.close();
//        temp.renameTo(file);

//    }







    public static void printBook()  throws IOException {

        FileReader fr = new FileReader("file.txt");
        Scanner inFile = new Scanner(fr);


        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            System.out.println(line);
        }
        inFile.close();

    }


    public static void findEmail(String email)  {

         try (Scanner scanner = new Scanner(new File("file.txt"))) {
            String s[];

            boolean foundPerson = false;

            while(scanner.hasNextLine()) {
                s = scanner.nextLine().split(" : ");
                if (s[2].equals(email)) {
                    System.out.println("The contact associated with: " + email + " is: "  + s[1] + " : " + s[0]); //+ number + Firstname + Lastname);
                    foundPerson = true;
                }
            }
            if(!foundPerson) {
                System.out.println("Could not find email account:  " + email);
            }

         }catch (IOException e) {
             System.out.println(e.getMessage());
         }

    }
    public static void displayMenu() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String Firstname;
        String Lastname;
        String email;
        long number;
        System.out.println("Which action would you like to perform? ");

        System.out.println("1) Add an contact: ");          //
        System.out.println("2) Remove a contact: ");
        System.out.println("3) Search for a specific contact using email: ");       //
        System.out.println("4) Print Address Book: ");              //
        System.out.println("5) Delete Address Book: ");             //
        System.out.println("6) Quit:");             //

        int exchange = scanner.nextInt();
        scanner.nextLine();

        switch (exchange) {
            case 1: {
                System.out.println("Add a contact: ");
                System.out.println("What is the first name of the contact that you wish to add and save?  ");
                Firstname = scanner.nextLine();
                System.out.println("What is the last name of the contact that you wish to add and save?  ");
                Lastname = scanner.nextLine();
                System.out.println("What is the contact telephone number? (1234567890) ");
                number = scanner.nextLong();
                scanner.nextLine();
                System.out.println("What is the email address associated with the contact?");
                email = scanner.nextLine();

               saveContact(Firstname, Lastname, number, email);
               // printBook(Firstname, Lastname, number, email);
            }
            break;
            case 2: {
                System.out.println("Remove a contact: ");



            }
            break;

            case 3: {
                System.out.println("Search for a specific contact with an email: ");
                System.out.println("What is the email account for the contact that you are searching for?");

                findEmail(scanner.nextLine());
            }
            break;

            case 4: {
                System.out.print("Address Book:");
                System.out.println("This is the contact list ");
                printBook();

            }
            break;

            case 5: {
                System.out.println("Delete address book: ");
                System.out.println("This action is not allowed by the user.");
            }
            break;

            case 6: {
                System.out.println("You chose to Exit address book: ");
            }
            break;

            default: {
                System.out.println("I don't recognize your selection. ");

            }
            break;
            }

        scanner.close();

    }


}
