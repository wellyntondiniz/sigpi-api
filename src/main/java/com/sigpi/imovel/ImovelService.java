package com.sigpi.imovel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	public List<Imovel> listarTodas(){
		return imovelRepository.findAll();
	}
	
}