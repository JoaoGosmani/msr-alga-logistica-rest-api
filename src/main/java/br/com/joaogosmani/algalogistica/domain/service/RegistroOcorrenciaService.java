package br.com.joaogosmani.algalogistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.joaogosmani.algalogistica.domain.model.Entrega;
import br.com.joaogosmani.algalogistica.domain.model.Ocorrencia;

@Service
public class RegistroOcorrenciaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long id, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(id);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
