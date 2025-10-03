package com.sigpi.parcelas;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigpi.aluguel.Aluguel;

@Service
public class ParcelasService {
	
	@Autowired
	ParcelasRepository parcelasRepository;
	
	public List<ParcelasDTO> gerarParcelas(Aluguel aluguel) {
		List<Parcelas> parcelas = new ArrayList<>();
		LocalDate dataVencimento = 
				getDiaNoMesSeguinte(aluguel.getData_inicio(), aluguel.getDia_cobranca());
		
		for (int i = 1; i <= aluguel.getMeses_duracao(); i++) {
			Parcelas parcela = new Parcelas();
			parcela.setAluguel_id(aluguel.getId());
			parcela.setDataVencimento(dataVencimento);
			parcela.setNumeroParcela(i);
			parcela.setSituacao(1);
			parcelasRepository.save(parcela);
			
			dataVencimento = dataVencimento.plusMonths(1);
		}
		
		return converterParcelasDTO(parcelas);
	}
	
    public static LocalDate getDiaNoMesSeguinte(LocalDate data, int dia) {
        YearMonth proximoMes = YearMonth.from(data).plusMonths(1);
        int ultimoDia = proximoMes.lengthOfMonth();
        int diaFinal = Math.min(dia, ultimoDia);
        return proximoMes.atDay(diaFinal);
    }
	
	private List<ParcelasDTO> converterParcelasDTO(List<Parcelas> parcelas) {
		List<ParcelasDTO> parcelasDTO = new ArrayList<>();
		
		parcelas.forEach(parcela -> {
			ParcelasDTO parcelaDTO = new ParcelasDTO();
			parcelaDTO.setId(parcela.getId());
			parcelaDTO.setAluguel_id(parcela.getAluguel_id());
			parcelaDTO.setDataVencimento(parcela.getDataVencimento());
			parcelaDTO.setNumeroParcela(parcela.getNumeroParcela());
			parcelaDTO.setSituacao(parcela.getSituacao().equals(1) ? "Aguardando pagamento" : "Paga");
		
			parcelasDTO.add(parcelaDTO);
		});
		
		return parcelasDTO;
	}

	public List<ParcelasDTO> getParcelas(Integer id) {
		return converterParcelasDTO(parcelasRepository.findAll());
	}

}
