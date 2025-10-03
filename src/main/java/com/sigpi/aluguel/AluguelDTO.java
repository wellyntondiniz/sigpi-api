package com.sigpi.aluguel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.sigpi.parcelas.ParcelasDTO;



public class AluguelDTO {
	private Integer id;
	
	private Integer proprietarioId;
	
	private Integer inquilinoId;
	
	private Integer imovelId;
	
	private LocalDate dataInicio;
	
	private Integer diaCobranca;
	
	private Integer mesesDuracao;
	
	private List<ParcelasDTO> parcelas;

	public Integer getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(Integer proprietarioId) {
		this.proprietarioId = proprietarioId;
	}

	public Integer getInquilinoId() {
		return inquilinoId;
	}

	public void setInquilinoId(Integer inquilinoId) {
		this.inquilinoId = inquilinoId;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getDiaCobranca() {
		return diaCobranca;
	}

	public void setDiaCobranca(Integer diaCobranca) {
		this.diaCobranca = diaCobranca;
	}

	public Integer getMesesDuracao() {
		return mesesDuracao;
	}

	public void setMesesDuracao(Integer mesesDuracao) {
		this.mesesDuracao = mesesDuracao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ParcelasDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelasDTO> parcelas) {
		this.parcelas = parcelas;
	}

	public Integer getImovelId() {
		return imovelId;
	}

	public void setImovelId(Integer imovelId) {
		this.imovelId = imovelId;
	}
	
	
	
}
