package noob.webapp.services;

import noob.webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
