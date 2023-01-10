package br.com.springcod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {

	
	@GetMapping("/somar/{num1}/{num2}")
	public int calcularSoma(@PathVariable int num1, @PathVariable int num2) {
		return num1 + num2;
	}
	
	@GetMapping("/subtrair")
	public int calcularSubtrair(@RequestParam(name = "num1") int num1, @RequestParam(name = "num2") int num2) {
		return num1 - num2;
	}
}
