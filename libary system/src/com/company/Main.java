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
            String addbook = Scan("Do you want to add a book? ");
            if (addbook.contains("Y") || addbook.contains("y")) {
                Scanner s = new Scanner(System.in);
                System.out.println("how many books do you wish to add? ");
                int booknum = s.nextInt();
                for (int i = 0; i < booknum; i++) {
                    booklibrary.add(getbookdetails());
                }
            }
            String checkbook = Scan("Do you want to lookup a book? ");
            if (checkbook.contains("Y") || addbook.contains("y")) {
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
            String bookname = Scan("name: ");
            String authorname = Scan("author: ");
            String genre = Scan("genre: ");
            Integer ISBN = Integer.valueOf(Scan("ISBN (4 Digits):"));
            return (bookname + ", " + authorname + ", " + genre + ", "+ISBN);
        }
        public static void Booklookup() {
            String infogiven = Scan("please provide any details you have of the book eg book title, isbn, author, genre");
            if (booklibrary.toString().contains(infogiven)) {
                System.out.println("book is in the library");
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
            ArrayList<String> usernames = new ArrayList<>();
            ArrayList<String> passwords = new ArrayList<>();
            usernames.add("Kvetch");
            passwords.add("password");
            String userInputname = Scan("username: ");
            String userInputpw = Scan("password: ");
            if (usernames.toString().contains(userInputname)){
                
            }
