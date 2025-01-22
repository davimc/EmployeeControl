package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_store")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer type;

    @OneToMany(mappedBy = "storeBeloging", cascade = CascadeType.MERGE)
    private List<Employee> employeesBeloging = new ArrayList<>();

    @OneToMany(mappedBy = "storeCurrent", cascade = CascadeType.MERGE)
    private List<Employee> employeesCurrent = new ArrayList<>();
    public Store() {
    }

    public Store(Long id, String name, StoreType type) {
        this.id = id;
        this.name = name;
        this.type = type.getCod();
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

    public StoreType getType() {
        return StoreType.toEnum(type);
    }

    public void setType(StoreType type) {
        this.type = type.getCod();
    }

    public List<Employee> getEmployeesBeloging() {
        return employeesBeloging;
    }

    public List<Employee> getEmployeesCurrent() {
        return employeesCurrent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store employee = (Store) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
