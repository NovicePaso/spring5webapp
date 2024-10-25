package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author tim = new Author("Timothy", "Kwock");
        Book firstBook = new Book("My Programming Journey", "0000001");
        tim.getBooks().add(firstBook);
        firstBook.getAuthors().add(tim);
        authorRepository.save(tim);
        bookRepository.save(firstBook);

        Author bob = new Author("Bob", "Ross");
        Book happyTrees = new Book("Happy Trees", "0000002");
        bob.getBooks().add(happyTrees);
        happyTrees.getAuthors().add(bob);
        authorRepository.save(bob);
        bookRepository.save(happyTrees);

        Publisher kanye = new Publisher("Kanye West", "100 West", "Beverly Hills",
                "California", "90035");
        publisherRepository.save(kanye);

        System.out.println("Initializing Boot Strap..." + '\n');
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
