package br.com.grupotsm.EmployeeControl.DTO.license;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

public class LicenseUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtStart;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtExpected;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtEnd;

    private Integer reason;


    public LicenseUpdateDTO() {
    }


    public LocalDate getDtStart() {
        return dtStart;
    }

    public LocalDate getDtExpected() {
        return dtExpected;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }

    public Integer getReason() {
        return reason;
    }

    public void toModel(License obj) {
        obj.setUpdated(Instant.now());
        obj.setDtEnd(dtEnd == null? obj.getDtEnd():dtEnd);
        obj.setDtExpected(dtExpected == null? obj.getDtExpected():dtExpected);
        obj.setDtStart(dtStart == null? obj.getDtStart():dtStart);
        obj.setReason(reason == null? obj.getReason():ReasonType.toEnum(reason));
    }
}
