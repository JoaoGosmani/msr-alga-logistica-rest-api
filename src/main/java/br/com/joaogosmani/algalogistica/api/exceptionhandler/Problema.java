package br.com.joaogosmani.algalogistica.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class Problema {

	private Integer status;
	
	private OffsetDateTime dataHora;	
	
	private String titulo;
	
	private List<Campo> campos;
	
	@Getter
	@AllArgsConstructor
	public static class Campo {
		
		private String nome;
		
		private String mensagem;
		
	}
	
}
