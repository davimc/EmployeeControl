package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.auth.LoginDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.User;
import br.com.grupotsm.EmployeeControl.services.AuthenticationService;
import br.com.grupotsm.EmployeeControl.services.EmployeeService;
import com.nimbusds.common.contenttype.ContentType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/token")
public class AuthenticationResource {

    private final AuthenticationService service;

    public AuthenticationResource(AuthenticationService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO login) {
        return service.login(login);
    }

}
