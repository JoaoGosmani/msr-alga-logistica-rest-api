package br.com.joaogosmani.algalogistica.api.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(SnakeCaseStrategy.class)
public class OcorrenciaModel {
	
	private Long id;
	
	private String descricao;
	
	private OffsetDateTime dataRegistro;

}
