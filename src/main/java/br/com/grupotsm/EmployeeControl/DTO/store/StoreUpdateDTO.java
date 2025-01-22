    package br.com.grupotsm.EmployeeControl.DTO.store;

import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class StoreUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @Size(message = "It is necessary to inform a name", min = 3, max = 25)
    private String name;
    @Positive(message = "This field need to be positive")
    private Integer type;
    private String typeName;

    public StoreUpdateDTO() {
    }

    public StoreUpdateDTO(Long id, String name, Integer type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public StoreUpdateDTO(Store obj) {
        id = obj.getId();
        name = obj.getName();
        typeName = obj.getType().getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public Store toModel(Store obj) {
        obj.setName(name==null? obj.getName():name);
        obj.setType(type==null? obj.getType():StoreType.toEnum(type));

        return obj;
    }
}
