package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.DatabaseException;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private StoreService storeService;

    @Transactional(readOnly = true)
    protected Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, EmployeeService.class));
    }

    @Transactional(readOnly = true)
    public Page<EmployeeShortDTO> findAll(Pageable pageable, boolean isAvailable) {
        Page<Employee> obj = repository.findAllActives(pageable);

        return obj.map(EmployeeShortDTO::new);
    }
    @Transactional(readOnly = true)
    public EmployeeDTO findDTOById(Long id) {
        Employee obj = findById(id);
        return new EmployeeDTO(obj);
    }

    public void delete(Long id) {
        try{
            repository.delete(findById(id));
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("There is a dependency");
        }
    }

    @Transactional
    public EmployeeShortDTO insert(EmployeeNewDTO newDTO) {
        Employee obj = newDTO.toModel();
        Store s = storeService.findById(newDTO.getStoreId());
        obj.setStoreBeloging(s);
        obj.setStoreCurrent(s);
        obj = repository.save(obj);

        return new EmployeeShortDTO(obj);
    }

    public EmployeeShortDTO update(Long id, EmployeeUpdateDTO updateDTO) {
        Employee obj = findById(id);
        obj = updateDTO.toModel(obj);
        obj = repository.save(obj);

        return new EmployeeShortDTO(obj);
    }
}
