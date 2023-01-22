package br.com.joaogosmani.algalogistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaogosmani.algalogistica.domain.exception.EntidadeNaoEncontradaException;
import br.com.joaogosmani.algalogistica.domain.model.Entrega;
import br.com.joaogosmani.algalogistica.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long id) {
		return entregaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}
