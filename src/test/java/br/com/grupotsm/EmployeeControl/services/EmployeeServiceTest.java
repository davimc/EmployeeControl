package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;
    @Mock
    private EmployeeRepository repository;
    @Mock
    private StoreService storeService;

    private Long existentId;
    private Long nonExistentId;
    private String name;
    private Character gender;
    private String email;
    private String cpf;
    private String password;
    private LocalDate birthdate;
    private LocalDate admissionDate;
    private Employee obj;
    private Store store;


    @BeforeEach
    void setup() {
        existentId = 1L;
        nonExistentId = 99L;
        name = "Severno Snape";
        gender = 'M';
        email = "test@gmail";
        cpf = "123.456.789-10";
        password = "test";
        birthdate = LocalDate.of(1995,2, 1);
        admissionDate = LocalDate.now();
        store = new Store(existentId, "Orleans Times", StoreType.COFFEE_SHOP);
        obj = new Employee(existentId, name, gender, email, cpf,password, admissionDate, birthdate, store);
    }

    @Test
    void findByIdWhenIdExistsShouldReturnObj() {
        when(repository.findById(existentId)).thenReturn(Optional.of(obj));

        Employee test = service.findById(existentId);

        Assertions.assertNotNull(test);
        Assertions.assertEquals(admissionDate, test.getDtAdmission());
    }

    @Test
    void findAll() {
    }

    @Test
    void findDTOById() {
    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }
}