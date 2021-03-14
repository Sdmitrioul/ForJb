package ru.forjb.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.security.Internal;
import ru.forjb.wp.service.ReaderService;

import javax.servlet.http.HttpSession;

@Controller
public class ReadersPage extends Page {
    private final ReaderService readerService;

    public ReadersPage(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/readers/all")
    public String allReaders(Model model) {
        model.addAttribute("readers", readerService.getAllReaders());
        return "AllReadersPage";
    }

    @GetMapping("/reader/{id}")
    public String getUser(HttpSession httpSession, Model model, @PathVariable String id) {
        long readerId = -1L;

        try {
            readerId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            putMessage(httpSession, "reader id can't be: " + id);
            return "redirect:";
        }

        Reader reader = readerService.findByReaderId(readerId);

        if (reader != null) {
            model.addAttribute("reader", reader);

            return "ReaderPage";
        }

        putMessage(httpSession, "No such reader");
        return "redirect:";
    }
}
