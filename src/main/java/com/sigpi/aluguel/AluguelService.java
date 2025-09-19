package com.sigpi.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	public List<Aluguel> listarTodas() {		
		return aluguelRepository.findAll();
	}

}
