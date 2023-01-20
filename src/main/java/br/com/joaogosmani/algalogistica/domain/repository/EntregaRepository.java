package br.com.joaogosmani.algalogistica.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaogosmani.algalogistica.domain.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
