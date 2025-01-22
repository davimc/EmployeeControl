package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.ExpedientType;
import br.com.grupotsm.EmployeeControl.entities.enums.ExchangeState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_exchange_temporary")
public class ExchangeTemporary extends Exchange{
    private LocalDate dtExpected;
    private LocalDate dtEnd;

    public ExchangeTemporary() {
    }

    public ExchangeTemporary(Long id, LocalDate dtStart, ExpedientType expedient, ExchangeState state, Employee employeeGenerator, Employee employeeExchanged, LocalDate dtExpected, LocalDate dtEnd) {
        super(id, dtStart, expedient, state, employeeGenerator, employeeExchanged);
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
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
}
