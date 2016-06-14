package br.projetovv.stub;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.projetovv.modelo.Sala;

@Entity(name="cinema")
public class Cinema {
	
	@Id
	@Column(name = "idCinema", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCinema;
	
	private String nome;
	private String endereco;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	
	@OneToMany(mappedBy = "cinema", targetEntity = Sala.class, fetch = FetchType.EAGER)
	private List<Sala> salas;
	
/* GET's & SET's*/
	
	public Long getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(Long idCinema) {
		this.idCinema = idCinema;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
}
