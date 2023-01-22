package br.com.joaogosmani.algalogistica.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaogosmani.algalogistica.api.assembler.OcorrenciaAssembler;
import br.com.joaogosmani.algalogistica.api.model.OcorrenciaModel;
import br.com.joaogosmani.algalogistica.api.model.input.OcorrenciaInput;
import br.com.joaogosmani.algalogistica.domain.model.Entrega;
import br.com.joaogosmani.algalogistica.domain.model.Ocorrencia;
import br.com.joaogosmani.algalogistica.domain.service.BuscaEntregaService;
import br.com.joaogosmani.algalogistica.domain.service.RegistroOcorrenciaService;

@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;
	
	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long id, 
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput
	) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(id, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
		
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
	
}
