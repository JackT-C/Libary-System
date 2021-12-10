package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
// so we are like halfway through this finish doing booklookup and main :)
public class Main {
    private static File libary = new File("booksystem.txt");
    private static ArrayList<String> booklibary = new ArrayList<>();

    public static void main(String[] args) {
        String addbook = Scan("Type Y if you wish to add a book, type N if you want to use another service ");
        if (addbook.contains("Y")) {
            Scanner s = new Scanner(System.in);
            System.out.println("how many books do you wish to add? ");
            int booknum = s.nextInt();
            for (int i = 0; i <booknum; i++) {
                booklibary.add(getbookdetails());
            }
        }
        String checkbook = Scan("Type Y if you wish to lookup a book, type N if you want to use another service ");
        if (checkbook.contains("Y")){
            Booklookup();
        }

    }
    public static String Scan(String question){
        System.out.println(question);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    public static String getbookdetails() {
        int ISBN = Integer.parseInt(Scan("What is the books ISBN number? "));
        String bookname = Scan("What is the books name? ");
        String authorname = Scan("What is the name of the author? ");
        String genre = Scan("What genre is the book? ");
        return (ISBN + ", " + bookname + ", " + authorname + ", " + genre);
    }
    public static void Booklookup() {
        String infogiven = Scan("please provide any details you have of the book eg book title, isbn, author, genre");
        if (booklibary.contains(infogiven)){
            System.out.println();
        }
        else{
            System.out.println("sorry we don't have that book");
        }
    }
    public static void CreateFile() {
        FileWriter writer = new FileWriter("output.txt");
        for(String s: booklibary){
            writer.write(s + System.lineSeparator());
        }
        writer.close();
    }

}
