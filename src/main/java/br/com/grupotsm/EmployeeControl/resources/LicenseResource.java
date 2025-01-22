package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.DTO.license.LicenseNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.license.LicenseUpdateDTO;
import br.com.grupotsm.EmployeeControl.services.LicenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/licenses")
public class LicenseResource {

    @Autowired
    private LicenseService service;

    @GetMapping
    public ResponseEntity<Page<LicenseDTO>> findAll(Pageable pageable,
                                                    @RequestParam(value="dtMin", defaultValue = "")String min,
                                                    @RequestParam(value="dtMax", defaultValue = "")String max,
                                                    @RequestParam(value = "justActives", defaultValue = "false") boolean justActives) {
        return ResponseEntity.ok().body(service.findAllActives(pageable, min, max, justActives));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LicenseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDTOById(id));
    }
    @PostMapping
    public ResponseEntity<LicenseDTO> insert(@RequestBody @Valid LicenseNewDTO newDTO) {
        LicenseDTO dto = service.insert(newDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<LicenseDTO> update(@PathVariable Long id, @RequestBody @Valid LicenseUpdateDTO updateDTO) {
        return ResponseEntity.accepted().body(service.update(id, updateDTO));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
