package turkcell.libaryspringboot.libary.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BusinessException {

    private static final String CODE = "INVALID_CREDENTIALS";

    public InvalidCredentialsException() {
        super(HttpStatus.UNAUTHORIZED, CODE, "E-posta veya şifre hatalı.");
    }
}
