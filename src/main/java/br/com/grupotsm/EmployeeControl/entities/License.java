package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_license")
public class License implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dtStart;
    private LocalDate dtExpected;
    private LocalDate dtEnd;
    private Integer reason;

    private LocalDate created;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")

    private Instant updated;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public License() {
    }

    public License(Long id, LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, ReasonType reason, Employee employee) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
        this.reason = reason.getPeriodSuggestion();
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDtStart() {
        return dtStart;
    }

    public void setDtStart(LocalDate dtStart) {
        this.dtStart = dtStart;
    }

    public LocalDate getDtExpected() {
        return dtExpected;
    }

    public void setDtExpected(LocalDate dtExpected) {
        this.dtExpected = dtExpected;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDate dtEnd) {
        this.dtEnd = dtEnd;
    }

    public ReasonType getReason() {
        return ReasonType.toEnum(reason);
    }

    public void setReason(ReasonType reason) {
        this.reason = reason.getPeriodSuggestion();
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License employee = (License) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isActive() {
        LocalDate today = LocalDate.now();
        boolean active = isValid();
        return active;
    }
    private boolean isValid() {
        LocalDate today = LocalDate.now();
        boolean isNotFinished = dtEnd == null;
        boolean isAfterStart = dtStart.isBefore(today) || dtStart.isEqual(today);
        boolean isBeforeExpected = dtExpected.isAfter(today) || dtExpected.isEqual(today);

        return isNotFinished && isAfterStart && isBeforeExpected;
    }
}
