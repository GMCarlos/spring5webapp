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
        Author eric = new Author("Eric", "Perez");
        Book ddd = new Book("El principe", "12354");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author carlos = new Author("Carlos", "Guillen");
        Book libro2 = new Book("Don Quijote", "71622");

        carlos.getBooks().add(libro2);
        libro2.getAuthors().add(carlos);

        authorRepository.save(carlos);
        bookRepository.save(libro2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of book " + bookRepository.count());


        //Ejercicio de Publisher

    }
}
