package br.com.grupotsm.EmployeeControl.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_employee")

public class Employee extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 1)
    private Character gender;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate dtAdmission;
    @Column(columnDefinition = "DATE")
    private LocalDate dtResignation;
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "store_beloging_id")
    private Store storeBeloging;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "store_current_id")
    private Store storeCurrent;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<License> licenses = new ArrayList<>();
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updated;
    @OneToMany(mappedBy = "employee")
    private List<Request> requests = new ArrayList<>();
    public Employee() {
    }

    public Employee(Long id, String name, Character gender, String email, String cpf, String password, LocalDate dtAdmission, LocalDate birthDate, Store store) {
        this.gender = gender;
        this.email = email;
        this.dtAdmission = dtAdmission;
        this.birthDate = birthDate;
        this.storeBeloging = store;
        this.storeCurrent = store;
    }

    public Employee(Long id, String name, Character gender, String email, String cpf, String password, LocalDate dtAdmission, LocalDate birthDate, Store storeOrigin, Store storeCurrent) {
        this.gender = gender;
        this.email = email;
        this.dtAdmission = dtAdmission;
        this.birthDate = birthDate;
        this.storeBeloging = storeOrigin;
        this.storeCurrent = storeCurrent;
    }


    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if(dtResignation.isBefore(dtAdmission))
            throw new IllegalArgumentException("Data de desligamento não pode ser anterior a data de contratação");
        this.dtResignation = dtResignation;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Store getStoreBeloging() {
        return storeBeloging;
    }

    public void setStoreBeloging(Store store) {
        this.storeBeloging = store;
    }

    public Store getStoreCurrent() {
        return storeCurrent;
    }

    public void setStoreCurrent(Store storeCurrent) {
        this.storeCurrent = storeCurrent;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isActive() {
        return (this.getLicenses().stream().filter(l -> l.isActive()).collect(Collectors.toList()).size() == 0);
    }

    public List<Request> getRequests() {
        return requests;
    }


}
