package br.com.grupotsm.EmployeeControl.DTO.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(min = 5, max = 32, message = "The name field needs to be filled in between 2 to 32 characters")
    private String name;
    private Character gender;

    @Email(message = "The email rule is not being fulfilled")
    private String email;
    @CPF(message = "CPF rule is not being fulfilled")
    private String cpf;

    @Past(message = "Date of birth cannot be current or future")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate admissionDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate resignationDate;

    public EmployeeUpdateDTO() {
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getResignationDate() {
        return resignationDate;
    }

    public Employee toModel(Employee obj) {
        obj.setUpdated(LocalDateTime.now());
        obj.setCpf(cpf == null? obj.getCpf():cpf);
        obj.setBirthDate(birthdate == null? obj.getBirthDate():birthdate);
        obj.setDtAdmission(admissionDate == null? obj.getDtAdmission():admissionDate);
        obj.setDtResignation(resignationDate== null? obj.getDtResignation():resignationDate);
        obj.setEmail(email == null? obj.getEmail():email);
        obj.setGender(gender == null? obj.getGender():gender);
        obj.setName(name == null? obj.getName(): name);

        return obj;
    }
}
