package ru.forjb.wp.controller;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.form.BookCredentials;
import ru.forjb.wp.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class IndexPage extends Page {
    private final UserService userService;

    public IndexPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public String index(HttpSession httpSession, Model model) {
        if (getUser(httpSession) != null) {
            model.addAttribute("bookForm", new BookCredentials());
            model.addAttribute("readerForm", new Reader());
            return "IndexPage";
        }
        return "redirect:/enter";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        unsetUser(httpSession);
        return "redirect:/";
    }
}
