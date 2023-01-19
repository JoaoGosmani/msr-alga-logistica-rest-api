package br.com.joaogosmani.algalogistica.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaogosmani.algalogistica.domain.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping
	public List<Cliente> listar() {
		var cliente1 = new Cliente(1L, "João", "joao@gmail.com", "55 97852-5843");
		var cliente2 = new Cliente(2L, "Maria", "maria@gmail.com", "55 9285-1453");
		
		return Arrays.asList(cliente1, cliente2);	
	}
	
}
