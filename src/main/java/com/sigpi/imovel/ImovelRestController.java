package com.sigpi.imovel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/imovel")
public class ImovelRestController {
	
	@Autowired
	private ImovelService imovelService;
	
	@GetMapping
	public List<Imovel> buscarTodas() {
		return imovelService.listarTodas();
	}
	
	
}
