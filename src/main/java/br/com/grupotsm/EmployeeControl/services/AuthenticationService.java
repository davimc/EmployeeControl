package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.auth.LoginDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

    @Value("${jwt.client.token-uri}")
    private String tokenUri;
    @Value("${jwt.client.id}")
    private String CLIENT_ID;
    @Value("${jwt.client.secret}")
    private String CLIENT_SECRET;
    @Value("${jwt.client.granttype}")
    private String GRANT_TYPE;

    private final RestTemplate restTemplate;

    public AuthenticationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> login(LoginDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", CLIENT_ID);
        formData.add("grant_type", GRANT_TYPE);
        formData.add("client_secret", CLIENT_SECRET);

        formData.add("username", dto.getUsername());
        formData.add("password", dto.getPassword());
        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(formData, headers);


        return restTemplate.postForEntity(tokenUri, request, String.class);
    }
}
