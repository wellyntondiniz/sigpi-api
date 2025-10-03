package com.sigpi.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/aluguel")
public class AluguelRestController {
	
	@Autowired
	AluguelService aluguelService;
	
	@GetMapping
	public List<AluguelDTO> buscarTodas() {
		return aluguelService.listarTodas();
	}
	
	@PostMapping
	public AluguelDTO alugar(@RequestBody AluguelDTO aluguel) {
		return aluguelService.alugar(aluguel);
	}

}
