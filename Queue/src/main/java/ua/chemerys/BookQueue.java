package ua.chemerys;

import java.util.PriorityQueue;
import java.util.Queue;

public class BookQueue {

    public static void main(String[] args) {
        Queue<Book> bookQueue = new PriorityQueue<>();
        Book book1 = new Book(233, "America", "John", "Fabula", 5);
        Book book2 = new Book(1233, "Europe", "John", "Fabula", 5);
        Book book3 = new Book(23, "Africa", "John", "Fabula", 5);
        Book book4 = new Book(75, "Asia", "John", "Fabula", 5);

        bookQueue.add(book3);
        bookQueue.add(book1);
        bookQueue.add(book2);
        bookQueue.add(book4);

        for (Book book: bookQueue) {
            System.out.println(book);
        }

        bookQueue.remove();
        System.out.println("After remove");

        for (Book book: bookQueue) {
            System.out.println(book);
        }

        bookQueue.remove();
        System.out.println("After remove");

        for (Book book: bookQueue) {
            System.out.println(book);
        }

        bookQueue.remove();
        System.out.println("After remove");

        for (Book book: bookQueue) {
            System.out.println(book);
        }

        bookQueue.remove();
    }
}
