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
public class Employee implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1)
    private Character gender;
    private String email;
    @Column(unique = true)
    private String cpf;
    private String password;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="tb_employee_role",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "employee")
    private List<Request> requests = new ArrayList<>();
    public Employee() {
    }

    public Employee(Long id, String name, Character gender, String email, String cpf, String password, LocalDate dtAdmission, LocalDate birthDate, Store store) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.dtAdmission = dtAdmission;
        this.birthDate = birthDate;
        this.storeBeloging = store;
        this.storeCurrent = store;
    }

    public Employee(Long id, String name, Character gender, String email, String cpf, String password, LocalDate dtAdmission, LocalDate birthDate, Store storeOrigin, Store storeCurrent) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.dtAdmission = dtAdmission;
        this.birthDate = birthDate;
        this.storeBeloging = storeOrigin;
        this.storeCurrent = storeCurrent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
