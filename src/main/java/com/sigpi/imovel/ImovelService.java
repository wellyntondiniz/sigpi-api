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
	
	public Imovel buscarPorId(Integer id){
		return imovelRepository.findById(id).get();
	}
	
	public Imovel salvar(Imovel imovel) {
		return imovelRepository.save(imovel);
	}
	
	public void deletar(Integer id) {
		Imovel imovel = imovelRepository.findById(id).get();
		
		imovelRepository.delete(imovel);
	}
	
}