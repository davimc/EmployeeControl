package br.com.grupotsm.EmployeeControl.DTO.license;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public class LicenseNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "It is necessary to inform an employee")
    private Long employeeId;
    @NotNull(message = "It is necessary to inform a created data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtStart;
    @NotNull(message = "It is necessary to inform a created data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Future(message = "A future date is required")
    private LocalDate dtExpected;

    @NotNull(message = "It is necessary to inform a reason")
    private Integer reason;


    public LicenseNewDTO() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }


    public LocalDate getDtStart() {
        return dtStart;
    }

    public LocalDate getDtExpected() {
        return dtExpected;
    }


    public Integer getReason() {
        return reason;
    }

    public License toModel(Employee employee) {
        License obj = new License(null, dtStart, dtExpected, null, ReasonType.toEnum(reason), employee);
        obj.setCreated(LocalDate.now());

        return obj;
    }
}
