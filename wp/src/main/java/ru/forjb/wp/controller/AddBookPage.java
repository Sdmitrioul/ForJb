package ru.forjb.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forjb.wp.domain.Book;
import ru.forjb.wp.form.UserCredentials;
import ru.forjb.wp.form.validator.BookCredentialsAddValidator;
import ru.forjb.wp.service.BookService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AddBookPage extends Page {
    private final BookService bookService;
    private final BookCredentialsAddValidator bookCredentialsAddValidator;

    public AddBookPage(BookService bookService, BookCredentialsAddValidator bookCredentialsAddValidator) {
        this.bookService = bookService;
        this.bookCredentialsAddValidator = bookCredentialsAddValidator;
    }

    @InitBinder("bookForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(bookCredentialsAddValidator);
    }

    @GetMapping("/add/book")
    public String registerGet(Model model) {
        model.addAttribute("bookForm", new Book());
        return "AddBookPage";
    }

    @PostMapping("/add/book")
    public String registerPost(@Valid @ModelAttribute("bookForm") Book bookForm,
                               BindingResult bindingResult,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "AddBookPage";
        }

        bookService.addBook(bookForm);
        return "redirect:/";
    }
}
