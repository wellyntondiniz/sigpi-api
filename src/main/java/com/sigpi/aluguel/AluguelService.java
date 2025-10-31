package com.sigpi.aluguel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigpi.imovel.Imovel;
import com.sigpi.parcelas.ParcelasDTO;
import com.sigpi.parcelas.ParcelasService;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private ParcelasService parcelasService;
	
	public List<AluguelDTO> listarTodas() {			
		return converterAluguelDTO(aluguelRepository.findAll());
	}
	
	public Aluguel buscarPorId(Integer id){
		return aluguelRepository.findById(id).get();
	}
	
	private List<AluguelDTO> converterAluguelDTO(List<Aluguel> listaAluguel) {
		List<AluguelDTO> listaAluguelDTO = new ArrayList<>();
		
		listaAluguel.forEach(aluguel -> {
			listaAluguelDTO.add(converterAluguelDTO(aluguel));			
		});
		
		return listaAluguelDTO;
	}
	
	private AluguelDTO converterAluguelDTO(Aluguel aluguel) {
		AluguelDTO aluguelDTO = new AluguelDTO();
		aluguelDTO.setId(aluguel.getId());
		aluguelDTO.setProprietarioId(aluguel.getPropritario());
		aluguelDTO.setInquilinoId(aluguel.getInquilino());
		aluguelDTO.setImovelId(aluguel.getImovel());
		aluguelDTO.setDataInicio(aluguel.getData_inicio());
		aluguelDTO.setDiaCobranca(aluguel.getDia_cobranca());
		aluguelDTO.setMesesDuracao(aluguel.getMeses_duracao());
		aluguelDTO.setParcelas(parcelasService.getParcelas(aluguel.getId()));
		return aluguelDTO;
	}
	
	public AluguelDTO alugar(AluguelDTO aluguelDTO) {
		
		validarAluguel(aluguelDTO);
		
		Aluguel aluguel = new Aluguel();
		aluguel.setData_inicio(aluguelDTO.getDataInicio());
		aluguel.setDia_cobranca(aluguelDTO.getDiaCobranca());
		aluguel.setInquilino(aluguelDTO.getInquilinoId());
		aluguel.setPropritario(aluguelDTO.getProprietarioId());
		aluguel.setMeses_duracao(aluguelDTO.getMesesDuracao());
		aluguel.setImovel(aluguelDTO.getImovelId());
		aluguelRepository.save(aluguel);	
		parcelasService.gerarParcelas(aluguel);
		
		return converterAluguelDTO(aluguel);
	}
	
	private void validarAluguel(AluguelDTO aluguel) {
		if (aluguel.getProprietarioId() == null) {
			throw new RuntimeException("Informe o proprietário.");
		}
		
		if (aluguel.getImovelId() == null) {
			throw new RuntimeException("Informe o imovel.");
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
