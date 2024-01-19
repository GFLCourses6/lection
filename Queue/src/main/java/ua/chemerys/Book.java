package ua.chemerys;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private int id;
    private String name;
    private String author;
    private String publisher;
    private int quantity;

    public Book() {
    }

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && quantity == book.quantity && Objects.equals(name, book.name)
                && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publisher, quantity);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        return Integer.compare(this.id, book.id);
    }
}
