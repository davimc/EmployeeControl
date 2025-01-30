package br.com.grupotsm.EmployeeControl.DTO.auth;

public class LoginDTO {
    private String id;
    private String name;
    private String password;
    private String authorities;

    public LoginDTO() {
    }

    public LoginDTO(String id, String username, String password, String grantType) {
        this.id = id;
        this.name = username;
        this.password = password;
        this.authorities = grantType;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthorities() {
        return authorities;
    }
}
