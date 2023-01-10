package br.com.springcod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcod3r.exerciciossb.models.ClienteModel;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteControler {

	@GetMapping(path = "/qualquer")
	public ClienteModel obterCliente() {
		return new ClienteModel(17, "igor", "71199975486");
	}
	
	@GetMapping("/{id}")
	public ClienteModel obterClientePorId(@PathVariable int id) {
		
		return new ClienteModel(id, "Maria", "777.785.998-21");
		
	}
	
	@GetMapping
	public ClienteModel obterClientePorId2(@RequestParam(name = "id") int id) {
		return new ClienteModel(id, "Italo Vinicius", "777.785.998-21");
	}
}
