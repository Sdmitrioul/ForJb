package ru.forjb.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.service.ReaderService;

@Component
public class ReaderCredentialsAddValidator implements Validator {
    private final ReaderService readerService;

    public ReaderCredentialsAddValidator(ReaderService readerService) {
        this.readerService = readerService;
    }

    public boolean supports(Class<?> clazz) {
        return Reader.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            Reader editForm = (Reader) target;
        }
    }
}
