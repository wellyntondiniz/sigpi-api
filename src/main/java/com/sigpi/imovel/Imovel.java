package com.sigpi.imovel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "imovel")
public class Imovel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "descricao")
    private String descricao;
	
	@Column(name = "rua")
    private String rua;
	
	@Column(name = "numero")
    private Integer numero;
	
	@Column(name = "bairro")
    private String bairro;
	
	@Column(name = "cidade")
    private String cidade;
	
	@Column(name = "cep")
    private String cep;
	
	@Column(name = "foto")
    private String foto;
}