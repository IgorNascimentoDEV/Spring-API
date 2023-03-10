
package br.com.springcod3r.exerciciossb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.springcod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	
	public Iterable<Produto> findByNomeContaining(String parteNome);
}
