package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
        private static File myObj = new File("Books.txt");
        private static ArrayList<String> booklibrary = new ArrayList<>();
        public static void main(String[] args) {
            Login();
            String addbook = Scan("Type Y if you wish to add a book, type N if you want to use another service ");
            if (addbook.contains("Y")) {
                Scanner s = new Scanner(System.in);
                System.out.println("how many books do you wish to add? ");
                int booknum = s.nextInt();
                for (int i = 0; i < booknum; i++) {
                    booklibrary.add(getbookdetails());
                }
            }
            String checkbook = Scan("Type Y if you wish to lookup a book, type N if you want to use another service ");
            if (checkbook.contains("Y")) {
                Booklookup();
            }
            CreateFIle();
            WriteToFile();
        }

        public static String Scan(String question) {
            System.out.println(question);
            Scanner s = new Scanner(System.in);
            return s.nextLine();
        }
        public static String getbookdetails() {
            String bookname = Scan("What is the books name? ");
            String authorname = Scan("What is the name of the author? ");
            String genre = Scan("What genre is the book? ");
            Integer ISBN = Integer.valueOf(Scan("What is the books ISBN? (4 Digits)"));
            return (bookname + ", " + authorname + ", " + genre + ", "+ISBN);
        }
        public static void Booklookup() {
            String infogiven = Scan("please provide any details you have of the book eg book title, isbn, author, genre");
            if (booklibrary.contains(infogiven)) {
                System.out.println("book is in the library in position "+booklibrary.stream().findAny());
            } else {
                System.out.println("sorry we don't have that book");
            }
        }
        public static void CreateFIle() {
            try {
                if (myObj.createNewFile()){
                    System.out.println("File created: "+myObj.getName());
                }else {
                    System.out.println("File already exists, any books added will be written to this file");
                }
            }catch (IOException e){
                System.out.println("an error occurred.");
                e.printStackTrace();
            }
        }
        public static void WriteToFile() {
            try {
                FileWriter writer = new FileWriter(myObj.getName(),true);
                writer.write(booklibrary.toString());
                writer.close();
            } catch (IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        public static void Login() {
            String username = Scan("Username: ");
            String password = Scan("Password: ");
            String validUsername = "Jack";
            String validUsername2 = "Emily";
            String validUsername3 = "Kvetch";
            String validpassword = "validpassword";
            String validpassword2 = "password";
            if(username.contains(validUsername)){
                System.out.println("Username recognised ");
            }
            if(username.contains(validUsername2)){
                System.out.println("Username recognised ");
            }
            if(username.contains(validUsername3)){
                System.out.println("Username recognised ");
            }
            if(password.contains(validpassword)){
                System.out.println("Access granted ");
            }
            if(password.contains(validpassword2)){
                System.out.println("Access granted ");
            }
        }

    }
