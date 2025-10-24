package com.sigpi.imovel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
	
	private ImovelRepository imovelRepository;
	
	public ImovelService(ImovelRepository imovelRepository) {
		super();
		this.imovelRepository = imovelRepository;
	}

	public List<Imovel> listarTodas(){
		return imovelRepository.findAll();
	}
	
	public Imovel buscarPorId(Integer id){
		return imovelRepository.findById(id).get();
	}
	
	public Imovel salvar(ImovelRequest req) {
		//return imovelRepository.save(imovel);
		return null;
	}
	
	public void deletar(Integer id) {
		Imovel imovel = imovelRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Imóvel inexistente"));
		
		imovelRepository.delete(imovel);
	}
	
}