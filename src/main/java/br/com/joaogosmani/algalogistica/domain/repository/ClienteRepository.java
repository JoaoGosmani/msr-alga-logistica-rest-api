package br.com.joaogosmani.algalogistica.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaogosmani.algalogistica.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNome(String nome);
	
	Optional<Cliente> findByEmail(String email);
	
}
