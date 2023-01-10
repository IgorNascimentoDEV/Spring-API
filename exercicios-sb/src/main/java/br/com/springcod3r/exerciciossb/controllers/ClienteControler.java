package br.com.springcod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcod3r.exerciciossb.model.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteControler {

	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(17, "igor", "71199975486");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId(@PathVariable int id) {
		
		return new Cliente(id, "Maria", "777.785.998-21");
		
	}
	
	@GetMapping
	public Cliente obterClientePorId2(@RequestParam(name = "id") int id) {
		return new Cliente(id, "Italo Vinicius", "777.785.998-21");
	}
}
