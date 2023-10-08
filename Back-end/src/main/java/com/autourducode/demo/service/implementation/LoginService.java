package com.autourducode.demo.service.implementation;

import com.autourducode.demo.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {
    private final ClientRepository clientRepository;
    //private JwtUtils jwtUtils;
}
