package turkcell.libaryspringboot.libary.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyRegisteredException extends BusinessException {

    private static final String CODE = "EMAIL_ALREADY_REGISTERED";

    public EmailAlreadyRegisteredException() {
        super(HttpStatus.CONFLICT, CODE, "Bu e-posta zaten kayıtlı.");
    }
}
