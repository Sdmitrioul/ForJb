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
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.form.validator.ReaderCredentialsAddValidator;
import ru.forjb.wp.service.ReaderService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AddReaderPage extends Page {
    private final ReaderService readerService;
    private final ReaderCredentialsAddValidator readerCredentialsAddValidator;

    public AddReaderPage(ReaderService readerService, ReaderCredentialsAddValidator readerCredentialsAddValidator) {
        this.readerService = readerService;
        this.readerCredentialsAddValidator = readerCredentialsAddValidator;
    }

    @InitBinder("readerForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(readerCredentialsAddValidator);
    }

    @GetMapping("/add/reader")
    public String registerGet(Model model) {
        model.addAttribute("readerForm", new Reader());
        return "AddReaderPage";
    }

    @PostMapping("/add/reader")
    public String registerPost(@Valid @ModelAttribute("readerForm") Reader readerForm,
                               BindingResult bindingResult,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "AddReaderPage";
        }

        readerService.addReader(readerForm);
        return "redirect:/readers/all";
    }
}
