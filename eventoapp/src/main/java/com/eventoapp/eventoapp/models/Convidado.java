package com.eventoapp.eventoapp.models;



import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Convidado {

	@Id
	private String rg;
	
	@NotNull(message = "campo nao pode ser nulu")
	private String nomeConvidado;
	
	@ManyToOne
	@NotNull(message = "campo nao pode ser nulu")
	private Evento evento;
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	
}
