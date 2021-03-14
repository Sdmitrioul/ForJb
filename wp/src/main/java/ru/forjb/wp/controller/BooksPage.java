package ru.forjb.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forjb.wp.domain.Book;
import ru.forjb.wp.form.BookCredentials;
import ru.forjb.wp.service.BookService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class BooksPage extends Page {
    private final BookService bookService;

    public BooksPage(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/all")
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "AllBooksPage";
    }

    @GetMapping("/book/{id}")
    public String getBook(HttpSession httpSession, Model model, @PathVariable String id) {
        long bookId = -1L;

        try {
            bookId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            putMessage(httpSession, "Book id can't be: " + id);
            return "redirect:";
        }

        Book book = bookService.findByBookId(bookId);

        if (book != null) {
            model.addAttribute("book", book);

            return "BookPage";
        }

        putMessage(httpSession, "No such book");
        return "redirect:";
    }
}
