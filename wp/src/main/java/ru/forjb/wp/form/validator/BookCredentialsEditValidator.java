package ru.forjb.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.forjb.wp.form.BookCredentials;
import ru.forjb.wp.service.BookService;

@Component
public class BookCredentialsEditValidator implements Validator {
    private final BookService bookService;

    public BookCredentialsEditValidator(BookService bookService) {
        this.bookService = bookService;
    }

    public boolean supports(Class<?> clazz) {
        return BookCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            BookCredentials editForm = (BookCredentials) target;
            if (!bookService.isCallNumberVacant(editForm.getCallNumber())) {
                errors.rejectValue("callNumber", "callNumber.is-in-use", "call number is in use already");
            }
        }
    }

}
