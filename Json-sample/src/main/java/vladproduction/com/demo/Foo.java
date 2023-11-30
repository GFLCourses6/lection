package vladproduction.com.demo;

import java.util.Objects;

public class Foo {

    private int id;
    private String title;

    public Foo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Foo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Foo foo = (Foo) object;
        return id == foo.id && Objects.equals(title, foo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
