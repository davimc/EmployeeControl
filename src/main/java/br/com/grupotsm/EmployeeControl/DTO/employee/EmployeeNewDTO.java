package br.com.grupotsm.EmployeeControl.DTO.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeNewDTO {

    @NotNull(message = "It is necessary to inform a name")
    @Size(min = 5, max = 32, message = "The password field needs to be filled in between 2 to 32 characters")
    private String name;
    private Character gender;

    @NotNull(message = "It is necessary to inform a email")
    @Email(message = "The email rule is not being fulfilled")
    private String email;
    @NotNull(message = "It is necessary to inform a cpf")
    @CPF(message = "CPF rule is not being fulfilled")
    private String cpf;
    @NotBlank(message = "It is necessary to inform a password")
    @Size(min = 5, max = 25, message = "The password field needs to be filled in between 5 to 25 characters")
    private String password;

    @NotNull(message = "It is necessary to inform a birthdate")
    @Past(message = "Date of birth cannot be current or future")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    @NotNull(message = "It is necessary to inform a admission date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate admissionDate;

    @NotNull(message = "It is necessary to inform a store")
    private Long storeId;

    public EmployeeNewDTO() {
    }

    public EmployeeNewDTO(String name, Character gender, String email, String cpf, String password, LocalDate birthdate, LocalDate admissionDate, Long storeId) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Employee toModel() {
        return new Employee(null, name, gender, email,cpf, password, admissionDate, birthdate, null);
    }
}
