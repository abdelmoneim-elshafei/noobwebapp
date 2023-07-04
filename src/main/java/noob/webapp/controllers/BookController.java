package noob.webapp.controllers;

import noob.webapp.repositories.BookRepository;
import noob.webapp.services.BookService;
import noob.webapp.services.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    String getBooks(Model model){
        model.addAttribute("books",bookService.findAll());
        return "books";
    }
}
