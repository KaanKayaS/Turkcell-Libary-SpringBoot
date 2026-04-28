package turkcell.libaryspringboot.libary.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import turkcell.libaryspringboot.libary.dto.LoginRequest;
import turkcell.libaryspringboot.libary.dto.RegisterRequest;
import turkcell.libaryspringboot.libary.entity.Student;
import turkcell.libaryspringboot.libary.exception.EmailAlreadyRegisteredException;
import turkcell.libaryspringboot.libary.exception.InvalidCredentialsException;
import turkcell.libaryspringboot.libary.repository.StudentRepository;

@Service
public class StudentServiceImpl {
    
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterRequest registerRequest) {

        if (studentRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyRegisteredException();
        }

        Student student = new Student();
        student.setName(registerRequest.getName());      
        student.setSurname(registerRequest.getSurname()); 
        student.setEmail(registerRequest.getEmail());
        
        student.setActive(true);
        student.setEmailConfirmed(false);
        student.setFinePoint(0);        
        

        String encodedPassword = this.passwordEncoder.encode(registerRequest.getPassword());
        student.setPassword(encodedPassword);

        studentRepository.save(student);
    }

    public String login(LoginRequest loginRequest) {

        Student student = this.studentRepository
                .findByEmail(loginRequest.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        boolean passwordMatch = this.passwordEncoder.matches(loginRequest.getPassword(), student.getPassword());

        if (!passwordMatch) {
            throw new InvalidCredentialsException();
        }

        return "Giriş başarılı";
    }
}