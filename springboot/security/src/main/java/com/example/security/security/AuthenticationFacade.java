package com.example.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade{

    @Override
    public Authentication getAuthentication() {
        return null;
    }
}
