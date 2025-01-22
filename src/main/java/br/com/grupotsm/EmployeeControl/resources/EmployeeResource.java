package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeUpdateDTO;
import br.com.grupotsm.EmployeeControl.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    // TODO for now isAvailable isn't work
    @GetMapping
    public ResponseEntity<Page<EmployeeShortDTO>> findAll(
            Pageable pageable,
            @RequestParam(name = "avaiable", defaultValue = "false") boolean isAvailable) {
        return ResponseEntity.ok().body(service.findAll(pageable, isAvailable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(service.findDTOById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeShortDTO> insert(@RequestBody @Valid EmployeeNewDTO newDTO) {
        EmployeeShortDTO dto = service.insert(newDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<EmployeeShortDTO> update(@PathVariable Long id, @RequestBody @Valid EmployeeUpdateDTO updateDTO) {
        return ResponseEntity.accepted().body(service.update(id, updateDTO));
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
