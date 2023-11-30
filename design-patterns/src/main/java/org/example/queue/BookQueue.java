package org.example.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class BookQueue {
    public static void main(String[] args) {
        Queue<Book> queue = new PriorityQueue<>(); // not thread safety
        Book b1 = new Book(222, "America", "John", "SPB", 5);
        Book b2 = new Book(75, "Europe", "John", "SPB", 5);
        Book b3 = new Book(242, "Arctica", "John", "SPB", 5);
        Book b4 = new Book(24, "Africa", "John", "SPB", 5);
        Book b5 = new Book(974, "Asia", "John", "SPB", 5);
        queue.add(b1);
        queue.add(b2);
        queue.add(b3);
        queue.add(b4);
        queue.add(b5);
        for (Book b: queue) {
            System.out.println(b);
        }
        queue.remove();
        System.out.println("After remove");
        for (Book b: queue) {
            System.out.println(b);
        }
        queue.remove();
        System.out.println("After remove");
        for (Book b: queue) {
            System.out.println(b);
        }
    }
}
