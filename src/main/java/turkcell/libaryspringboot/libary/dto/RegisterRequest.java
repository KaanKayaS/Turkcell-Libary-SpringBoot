package turkcell.libaryspringboot.libary.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Ad alanı boş bırakılamaz")
    @Size(min = 2, max = 100, message = "Ad alanı en az 2, en fazla 100 karakter olmalıdır")
    private String name;

    @NotBlank(message = "Soyad alanı boş bırakılamaz")
    @Size(min = 2, max = 100, message = "Soyad alanı en az 2, en fazla 100 karakter olmalıdır")
    private String surname;

    @NotBlank(message = "Email alanı boş bırakılamaz")
    @Email(message = "Lütfen geçerli bir email adresi giriniz")
    @Size(max = 150, message = "Email en fazla 150 karakter olabilir")
    private String email;

    @NotBlank(message = "Şifre alanı boş bırakılamaz")
    @Size(min = 6, max = 50, message = "Şifre en az 6 karakter olmalıdır")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}