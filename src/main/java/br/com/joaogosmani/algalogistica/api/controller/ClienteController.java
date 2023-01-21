package br.com.joaogosmani.algalogistica.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaogosmani.algalogistica.api.assembler.ClienteAssembler;
import br.com.joaogosmani.algalogistica.api.model.ClienteModel;
import br.com.joaogosmani.algalogistica.api.model.input.ClienteInput;
import br.com.joaogosmani.algalogistica.domain.model.Cliente;
import br.com.joaogosmani.algalogistica.domain.repository.ClienteRepository;
import br.com.joaogosmani.algalogistica.domain.service.CatalogoClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CatalogoClienteService catalogoClienteService;
	
	@Autowired
	private ClienteAssembler clienteAssembler;
	
	@GetMapping
	public List<ClienteModel> listar() {
		return clienteAssembler.toCollectionModel(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteModel> buscar(@PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(cliente -> ResponseEntity.ok(clienteAssembler.toModel(cliente)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar(@Valid @RequestBody ClienteInput clienteInput) {
		Cliente novoCliente = clienteAssembler.toEntity(clienteInput);
		Cliente cliente = catalogoClienteService.salvar(novoCliente);
		
		return clienteAssembler.toModel(cliente); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteModel> atualizar(@Valid @PathVariable Long id, 
			@RequestBody ClienteInput clienteInput
	) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente cliente = clienteAssembler.toEntity(clienteInput);
		
		cliente.setId(id);
		cliente = catalogoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(clienteAssembler.toModel(cliente));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		catalogoClienteService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
