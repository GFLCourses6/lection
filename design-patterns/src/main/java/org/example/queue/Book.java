package org.example.queue;

import java.util.Objects;

public class Book implements Comparable<Book>{

    private int id;
    private String name;
    private String author;
    private String publisher;
    private int quantity;

    public Book(){ // we need for serialization\deserialization
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
        return id == book.id && quantity == book.quantity && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
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
    public int compareTo(Book book) { /* отвечает за приоритет, приоритет выставляется на основе id*/
        return Integer.compare(this.id, book.id);
    }
    // когда книжки будут попадать в очередь, то в голове очереди будет книжка с наибольшим приоритетом по id.
    // голова очереди - начало очереди и когда хотим достать что то из черги, то вытягиваем с головы
    // элемент очереди с наивысшим приоритетом находится в голове
}
