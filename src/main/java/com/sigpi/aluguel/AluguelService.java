package com.sigpi.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sigpi.pessoa.Pessoa;
import com.sigpi.pessoa.PessoaService;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	public List<Aluguel> listarTodas() {		
		return aluguelRepository.findAll();
	}
	
	public AluguelDTO alugar(AluguelDTO aluguelDTO) {
		
		validarAluguel(aluguelDTO);
		
		Aluguel aluguel = new Aluguel();
		aluguel.setData_inicio(aluguelDTO.getDataInicio());
		aluguel.setDia_cobranca(aluguelDTO.getDiaCobranca());
		
		Pessoa inquilino = pessoaService.getById(aluguelDTO.getInquilinoId());
		aluguel.setInquilino(inquilino);
		
		Pessoa proprietario = pessoaService.getById(null);
		aluguel.setPropritario(proprietario);
		
		aluguelRepository.save(aluguel);
		
		return aluguelDTO;
	}
	
	private void validarAluguel(AluguelDTO aluguel) {
		if (aluguel.getProprietarioId() == null) {
			throw new RuntimeException("Informe o proprietário.");
		}
		
		if (aluguel.getInquilinoId() == null) {
			throw new RuntimeException("Informe o inquilino.");
		}
		
		if (aluguel.getDataInicio() == null) {
			throw new RuntimeException("Informe a data de início do aluguel.");
		}
		
		if (aluguel.getMesesDuracao() == null) {
			throw new RuntimeException("Informe a quantidade de meses de duração do aluguel.");
		}
		
		if (aluguel.getDiaCobranca() == null) {
			throw new RuntimeException("Informe o dia de cobrança.");
		}
	}
	

}
