package noob.webapp.bootstrap;

import noob.webapp.domain.Author;
import noob.webapp.domain.Book;
import noob.webapp.domain.Publisher;
import noob.webapp.repositories.AuthorRepository;
import noob.webapp.repositories.BookRepository;
import noob.webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Doe");

        Author savedauthor1 = authorRepository.save(author1);

        Author author2 = new Author();
        author2.setFirstName("Jane");
        author2.setLastName("Smith");

        Author savedautohr2 = authorRepository.save(author2);

        Author author3 = new Author();
        author3.setFirstName("Michael");
        author3.setLastName("Johnson");

        Author savedauthor3 = authorRepository.save(author3);

        Author author4 = new Author();
        author4.setFirstName("Emily");
        author4.setLastName("Davis");

        Author savedauthor4 = authorRepository.save(author4);
        // Create books
        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setIsbn("123456789");

        Book savedBook1 = bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setIsbn("987654321");

        Book savedBook2 = bookRepository.save(book2);
        // Create books
        Book book3 = new Book();
        book3.setTitle("Book 3");
        book3.setIsbn("456789123");

        Book savedBook3 = bookRepository.save(book3);

        Book book4 = new Book();
        book4.setTitle("Book 4");
        book4.setIsbn("321654987");

        Book savedBook4 = bookRepository.save(book4);

        Publisher publisher = new Publisher();
        publisher.setName("Orilly");
        publisher.setAddress("New York");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Express");
        publisher2.setAddress("Lindon");

        Publisher savedPublisher1 = publisherRepository.save(publisher);
        Publisher savedPublisher2 = publisherRepository.save(publisher2);


        savedauthor1.getBooks().add(book1);
        savedautohr2.getBooks().add(book2);
        savedBook1.getAuthors().add(savedauthor1);
        savedBook2.getAuthors().add(savedautohr2);

        savedauthor3.getBooks().add(book3);
        savedauthor3.getBooks().add(book4);

        savedauthor4.getBooks().add(book3);
        savedauthor4.getBooks().add(book4);

        savedBook3.getAuthors().add(author3);
        savedBook3.getAuthors().add(author4);

        savedBook4.getAuthors().add(author3);
        savedBook4.getAuthors().add(author4);

        savedBook1.setPublisher(savedPublisher1);
        savedBook2.setPublisher(savedPublisher1);
        savedBook3.setPublisher(savedPublisher2);
        savedBook4.setPublisher(savedPublisher2);

        savedPublisher1.getBooks().add(savedBook1);
        savedPublisher1.getBooks().add(savedBook2);
        savedPublisher2.getBooks().add(savedBook3);
        savedPublisher2.getBooks().add(savedBook4);

        bookRepository.save(savedBook1);
        bookRepository.save(savedBook2);
        bookRepository.save(savedBook3);
        bookRepository.save(savedBook4);


        authorRepository.save(savedauthor1);
        authorRepository.save(savedautohr2);
        authorRepository.save(savedauthor3);
        authorRepository.save(savedauthor4);

        publisherRepository.save(savedPublisher1);
        publisherRepository.save(savedPublisher2);


        System.out.println("In bootstrap");
        System.out.println("the Book Count is :" + bookRepository.count());
        System.out.println("the Author Count is :" + authorRepository.count());
        System.out.println("the Publisher Count is :" + publisherRepository.count());


    }
}
