package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.RequestState;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_request")
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate dtProposedStart;
    private LocalDate dtProposedEnd;

    private LocalDate dtAcceptedStart;
    private LocalDate dtAcceptedEnd;
    private LocalDate dtEnd;
    private Integer state;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="exchange_id")
    private Exchange exchange;

    public Request() {
    }

    public Request(Long id, LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, RequestState state, Employee employee, Exchange exchange) {
        this.id = id;
        this.dtProposedStart = dtStart;
        this.dtProposedEnd = dtExpected;
        this.dtEnd = dtEnd;
        this.state = state.getCod();
        this.employee = employee;
        this.exchange = exchange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDtProposedStart() {
        return dtProposedStart;
    }

    public void setDtProposedStart(LocalDate dtProposedStart) {
        this.dtProposedStart = dtProposedStart;
    }

    public LocalDate getDtProposedEnd() {
        return dtProposedEnd;
    }

    public void setDtProposedEnd(LocalDate dtProposedEnd) {
        this.dtProposedEnd = dtProposedEnd;
    }

    public LocalDate getDtAcceptedStart() {
        return dtAcceptedStart;
    }

    public void setDtAcceptedStart(LocalDate dtAcceptedStart) {
        this.dtAcceptedStart = dtAcceptedStart;
    }

    public LocalDate getDtAcceptedEnd() {
        return dtAcceptedEnd;
    }

    public void setDtAcceptedEnd(LocalDate dtAcceptedEnd) {
        this.dtAcceptedEnd = dtAcceptedEnd;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDate dtEnd) {
        this.dtEnd = dtEnd;
    }

    public RequestState getState() {
        return RequestState.toEnum(state);
    }

    public void setState(RequestState state) {
        this.state = state.getCod();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id.equals(request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
