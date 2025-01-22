package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.store.StoreNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.store.StoreDTO;
import br.com.grupotsm.EmployeeControl.DTO.store.StoreUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;
import br.com.grupotsm.EmployeeControl.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/stores")
public class StoreResource {

    @Autowired
    private StoreService service;

    @GetMapping("/types")
    public ResponseEntity<List<StoreType>> types() {
        return ResponseEntity.ok().body(service.getTypes());
    }
    @GetMapping()
    public ResponseEntity<List<StoreDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name,
                                                     @RequestParam(name = "type", defaultValue = "0") Integer type) {
        return ResponseEntity.ok().body(service.findStores(name,type));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreDTO> findExpanded(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findExpanded(id));
    }
    @PostMapping
    public ResponseEntity<StoreDTO> insert(@RequestBody @Valid StoreNewDTO newDTO) {
        StoreDTO dto = service.insert(newDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<StoreUpdateDTO> update(@PathVariable Long id, @RequestBody @Valid StoreUpdateDTO updateDTO) {
        return ResponseEntity.accepted().body(service.update(id, updateDTO));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
