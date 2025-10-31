package com.sigpi.parcelas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/parcelas")
public class ParcelasRestController {
	
	@Autowired
	ParcelasService parcelasService;
	
	@GetMapping("/vencimento")
	public List<ParcelasDTO> buscarTodasDisponiveis() {
		return parcelasService.listarVencimento();
	}

}
