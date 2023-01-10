package br.com.springcod3r.exerciciossb.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcod3r.exerciciossb.model.entities.Produto;
import br.com.springcod3r.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public Produto novoProduto(@Validated Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	
	@GetMapping
	public Iterable<Produto> buscarProdutos(){
		 return produtoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> buscarProdutosPorId(@PathVariable int id){
		  return produtoRepository.findById(id);
	}

}
