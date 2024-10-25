package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("Initializing Boot Strap...");
        System.out.println("Number of Books: " + authorRepository.count());
    }
}
