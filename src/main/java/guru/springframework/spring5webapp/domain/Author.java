package guru.springframework.spring5webapp.domain;

import java.util.Set;

public class Author {
    private String firstName;
    private String latName;
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String latName, Set<Book> books) {
        this.firstName = firstName;
        this.latName = latName;
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLatName() {
        return latName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLatName(String latName) {
        this.latName = latName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
