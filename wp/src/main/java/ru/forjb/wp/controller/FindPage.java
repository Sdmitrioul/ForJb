package ru.forjb.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forjb.wp.domain.Book;
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.form.BookCredentials;
import ru.forjb.wp.service.BookService;
import ru.forjb.wp.service.ReaderService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FindPage extends Page {
    private final ReaderService readerService;
    private final BookService bookService;

    public FindPage(ReaderService readerService, BookService bookService) {
        this.readerService = readerService;
        this.bookService = bookService;
    }

    @PostMapping("/find/book")
    public String findBook(@ModelAttribute("bookForm") BookCredentials bookForm, HttpSession httpSession, Model model) {
        Book book = bookService.findByBookCallNumber(bookForm.getCallNumber());
        if (book == null) {
            model.addAttribute("message", "There no book with call number: " + bookForm.getCallNumber());
            return "NoSuchItemPage";
        }
        model.addAttribute("book", book);
        return "BookPage";
    }

    @PostMapping("/find/reader")
    public String findReader(@ModelAttribute("readerForm") Reader readerForm, HttpSession httpSession, Model model) {
        List<Reader> readers = readerService.findByReaderNameAndSurname(readerForm);
        model.addAttribute("readers", readers);
        return "AllReadersPage";
    }


}
