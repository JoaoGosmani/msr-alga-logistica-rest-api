package br.com.joaogosmani.algalogistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.joaogosmani.algalogistica.domain.model.Entrega;
import br.com.joaogosmani.algalogistica.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService; 
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
		
		entrega.finalizar();;
		
		entregaRepository.save(entrega);
	}
	
}
