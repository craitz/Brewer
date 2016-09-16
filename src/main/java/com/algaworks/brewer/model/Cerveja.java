package com.algaworks.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.algaworks.brewer.validation.Sku;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Sku
	@NotBlank(message = "O campo sku é obrigatório.")
	private String sku;

	@NotBlank(message = "O campo nome é obrigatório.")
	private String nome;

	@Size(min = 5, max = 40, message = "O campo descrição deve ter entre 5 e 40 caracteres.")
	private String descricao;

	private String foto;

	@Column(name = "content_type")
	private String contentType;

	@NotNull(message = "O campo valor é obrigatório.")
	@DecimalMin(value = "0.01", message = "O valor da cerveja deve ser maior que zero.")
	@DecimalMax(value = "9999999.99", message = "O valor da cerveja deve ser menor que R$9.999.999,99.")
	private BigDecimal valor;

	@NotNull(message = "O campo teor alcoólico é obrigatório.")
	@DecimalMin(value = "0.01", message = "O valor do campo teor alcoólico deve ser maior que zero.")
	@DecimalMax(value = "100.0", message = "O valor do campo teor alcoólico deve ser menor ou igual a 100%.")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;

	@NotNull(message = "O campo comissão é obrigatório.")
	@DecimalMin(value = "0.01", message = "O valor do campo comissão deve ser maior que zero.")
	@DecimalMax(value = "100.0", message = "O valor do campo comissão deve ser menor ou igual a 100%.")
	private BigDecimal comissao;

	@NotNull(message = "O campo estoque é obrigatório.")
	@Max(value = 9999, message = "O valor do campo estoque deve menor que 9.999.")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;

	@NotNull(message = "O campo origem é obrigatório.")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message = "O campo sabor é obrigatório.")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;

	@NotNull(message = "O campo estilo é obrigatório.")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
		
	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		sku = sku.toUpperCase();
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
