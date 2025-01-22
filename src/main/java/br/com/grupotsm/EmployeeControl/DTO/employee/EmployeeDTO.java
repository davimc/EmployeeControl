package br.com.grupotsm.EmployeeControl.DTO.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;

import java.time.LocalDate;

public class EmployeeDTO {

    private long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private LocalDate dtAdmission;
    private LocalDate dtResignation;
    private String storeBelogingName;
    private String storeCurrentName;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String name, String email, String cpf, LocalDate birthDate, LocalDate dtAdmission, LocalDate dtResignation, String storeBelogingName, String storeCurrentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.dtAdmission = dtAdmission;
        this.dtResignation = dtResignation;
        this.storeBelogingName = storeBelogingName;
        this.storeCurrentName = storeCurrentName;
    }
    public EmployeeDTO(Employee obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        cpf = obj.getCpf();
        birthDate = obj.getBirthDate();
        dtAdmission = obj.getDtAdmission();
        dtResignation = obj.getDtResignation();
        storeBelogingName = obj.getStoreBeloging().getName();
        storeCurrentName = obj.getStoreCurrent().getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDtAdmission() {
        return dtAdmission;
    }

    public void setDtAdmission(LocalDate dtAdmission) {
        this.dtAdmission = dtAdmission;
    }

    public LocalDate getDtResignation() {
        return dtResignation;
    }

    public void setDtResignation(LocalDate dtResignation) {
        this.dtResignation = dtResignation;
    }

    public String getStoreBelogingName() {
        return storeBelogingName;
    }

    public void setStoreBelogingName(String storeBelogingName) {
        this.storeBelogingName = storeBelogingName;
    }

    public String getStoreCurrentName() {
        return storeCurrentName;
    }

    public void setStoreCurrentName(String storeCurrentName) {
        this.storeCurrentName = storeCurrentName;
    }
}
