package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {

	@Autowired
	private CurriculoService curriculoService;

	@PostMapping("/add")
	public ResponseEntity<String> adicionarCurriculo(@RequestBody Curriculo curriculo) {
		try {
			curriculoService.adicionarCurriculo(curriculo);
			return new ResponseEntity<>("Currículo adicionado com sucesso!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao adicionar currículo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> excluirCurriculo(@PathVariable Long id) {
		try {
			curriculoService.excluirCurriculo(id);
			return new ResponseEntity<>("Currículo excluído com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao excluir currículo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<String> atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
		try {
			curriculoService.atualizarCurriculo(id, curriculo);
			return new ResponseEntity<>("Currículo atualizado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao atualizar currículo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Curriculo>> listarCurriculos() {
		try {
			List<Curriculo> curriculos = curriculoService.listarCurriculos();
			return new ResponseEntity<>(curriculos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
