package br.com.grupotsm.EmployeeControl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;

import java.util.Arrays;

@Configuration
public class ResourceServerConfig {

    @Autowired
    private Environment env;

    /*//TODO alterar caminhos
    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};
    private static final String[] ALL_USERS = {"/employees/**"};

    private static final String[] CLIENT_OR_ADMIN = {"/events/**"};
    private static final String[] ONLY_ADMIN = {"/users/**"};


    public void configure(HttpSecurity http) throws Exception {

        if(Arrays.asList(env.getActiveProfiles()).contains("test"))
            http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));


        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry.requestMatchers())

                /*
                .antMatchers(HttpMethod.GET, ALL_USERS).permitAll()
                .antMatchers(ALL_USERS).hasAnyRole("OPERATOR","ADMIN")
                .antMatchers(ALL_USERS).hasAnyRole("ADMIN")
                .antMatchers(CLIENT_OR_ADMIN).hasAnyRole("CLIENT")
                .antMatchers(ONLY_ADMIN).hasAnyRole("ADMIN")
                .anyRequest().permitAll();
    }*/
}
