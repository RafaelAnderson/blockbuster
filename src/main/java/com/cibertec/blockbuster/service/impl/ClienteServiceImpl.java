package com.cibertec.blockbuster.service.impl;

import com.cibertec.blockbuster.model.Cliente;
import com.cibertec.blockbuster.repository.ClienteRepository;
import com.cibertec.blockbuster.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
}
