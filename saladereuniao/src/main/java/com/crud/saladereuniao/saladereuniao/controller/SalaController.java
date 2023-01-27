package com.crud.saladereuniao.saladereuniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.saladereuniao.saladereuniao.exception.ResourceNotFoundException;
import com.crud.saladereuniao.saladereuniao.model.Sala;
import com.crud.saladereuniao.saladereuniao.repository.SalaRepository;



@RestController 
@RequestMapping("/api/v1")
public class SalaController {

	@Autowired
	private SalaRepository salaRepository;


	@GetMapping("/salas")
	public List<Sala> getAllSalas(){
		return salaRepository.findAll();
		
	}
	
	@GetMapping("/salas/{id}")
	public ResponseEntity<Sala> getSalaById(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		
		Sala sala = salaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sala nao encontrada "+id));
			
		return ResponseEntity.ok().body(sala);
		
	}
	
	@PostMapping("/salas")
	public Sala createSala(@Validated @RequestBody Sala sala) {
		return salaRepository.save(sala);
	}
	
	@PutMapping("/salas/{id}")
	public ResponseEntity<Sala> updateSala(@PathVariable(value = "id") long id, @Validated @RequestBody Sala salaDetalhes) throws ResourceNotFoundException{
		
		Sala sala = salaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sala não encontrada digite outro id::"+id));
		
		sala.setNome(salaDetalhes.getNome());
		sala.setData(salaDetalhes.getData());
		sala.setHoraFim(salaDetalhes.getHoraFim());
		sala.setHoraInicio(salaDetalhes.getHoraInicio());
		
		final Sala updateSala = salaRepository.save(sala);
		
		return ResponseEntity.ok(updateSala);
	}
	
	@DeleteMapping("/salas/{id}")
	public Map<String, Boolean> deleteSala(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		
		Sala sala = salaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sala não encontrada digite outro id::"+id)); 
		salaRepository.delete(sala);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
