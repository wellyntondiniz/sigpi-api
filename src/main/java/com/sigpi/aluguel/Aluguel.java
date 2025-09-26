package com.sigpi.aluguel;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sigpi.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluguel")
public class Aluguel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "proprietario_id")
	private Integer propritario;

	@Column(name = "inquilino_id")
	private Integer inquilino;

	@Column(name = "data_inicio")
	private Date data_inicio;

	@Column(name = "dia_cobranca")
	private Integer dia_cobranca;
	
	@Column(name = "meses_duracao")
	private Integer meses_duracao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Integer getDia_cobranca() {
		return dia_cobranca;
	}

	public void setDia_cobranca(Integer dia_cobranca) {
		this.dia_cobranca = dia_cobranca;
	}

	public Integer getMeses_duracao() {
		return meses_duracao;
	}

	public void setMeses_duracao(Integer meses_duracao) {
		this.meses_duracao = meses_duracao;
	}
	
	
	
	
}
