package com.sigpi.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/aluguel")
public class AluguelRestController {
	
	@Autowired
	AluguelService aluguelService;
	
	@GetMapping
	public List<Aluguel> buscarTodas() {
		return aluguelService.listarTodas();
	}

}
