package com.sigpi.aluguel;

import java.sql.Date;



public class AluguelDTO {
	private Integer id;
	
	private Integer proprietarioId;
	
	private Integer inquilinoId;
	
	private Date dataInicio;
	
	private Integer diaCobranca;
	
	private Integer mesesDuracao;

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
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
	
}
