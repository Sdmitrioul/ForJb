package ru.forjb.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.forjb.wp.domain.Book;
import ru.forjb.wp.form.BookCredentials;
import ru.forjb.wp.form.validator.BookCredentialsEditValidator;
import ru.forjb.wp.service.BookService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EditBookPage extends Page {
    private final BookService bookService;
    private final BookCredentialsEditValidator bookCredentialsEditValidator;

    public EditBookPage(BookService bookService, BookCredentialsEditValidator bookCredentialsEditValidator) {
        this.bookService = bookService;
        this.bookCredentialsEditValidator = bookCredentialsEditValidator;
    }

    @InitBinder("bookForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(bookCredentialsEditValidator);
    }


    @GetMapping("/book/edit/{id}")
    public String editBook(HttpSession httpSession, Model model, @PathVariable String id) {
        long bookId = -1L;

        try {
            bookId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            putMessage(httpSession, "Book id can't be: " + id);
            return "redirect:";
        }

        Book book = bookService.findByBookId(bookId);

        if (book != null) {
            BookCredentials bookCredentials = new BookCredentials(book);
            model.addAttribute("bookForm", bookCredentials);
            return "EditBookPage";
        }

        putMessage(httpSession, "No such book");
        return "redirect:";
    }

    @PostMapping("/book/edit/{id}")
    public String editingBook(@Valid @ModelAttribute("bookForm") BookCredentials book,
                              BindingResult bindingResult,
                              HttpSession httpSession, @PathVariable String id) {
        if (bindingResult.hasErrors()) {
            Book bookF = bookService.findByBookId(Long.parseLong(id));
            book.setId(bookF.getId());
            book.setTitle(bookF.getTitle());
            book.setAuthor(bookF.getAuthor());
            return "EditBookPage";
        }
        book.setId(Long.parseLong(id));
        bookService.saveEditing(book);
        return "redirect:/books/all";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(HttpSession httpSession, @PathVariable String id) {
        bookService.deleteBook(Long.parseLong(id));
        return "redirect:/books/all";
    }
}
