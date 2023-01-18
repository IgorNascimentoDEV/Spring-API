package com.crud.saladereuniao.saladereuniao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala_reuniao")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nome", nullable=false)
	private String nome;
	

	@Column(name="data", nullable=false)
	private String data;

	@Column(name="horaInicio", nullable=false)
	private String horaInicio;
	
	@Column(name="horaFim", nullable=false)
	private String horaFim;
	
	
	
	
	public Sala() {
		
	}
	
	
	public Sala(long id, String nome, String data, String horaInicio, String horaFim) {
		
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.horaFim = horaFim;
		this.horaInicio = horaInicio;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String date) {
		this.data = date;
	}


	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	
	@Override
	public String toString() {
		return "Sala [id= "+id+", nome= "+nome+", horario= "+horaInicio+", ate= "+horaFim+"]";
	}
	
}
