package com.sigpi.parcelas;

import java.time.LocalDate;

public class ParcelasDTO {
    
	private Integer id;

    private Integer aluguel_id;

    private LocalDate dataVencimento;

    private Integer numeroParcela;

    private String situacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAluguel_id() {
		return aluguel_id;
	}

	public void setAluguel_id(Integer aluguel_id) {
		this.aluguel_id = aluguel_id;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
