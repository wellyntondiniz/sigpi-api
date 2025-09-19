package com.sigpi.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarTodas() {
		return pessoaRepository.findAll(); 
	}
	
	

}
