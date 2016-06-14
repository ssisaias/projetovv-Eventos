package br.projetovv.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.projetovv.stub.Cinema;


@Entity(name="sala")
public class Sala {
	
	@Id
	@Column(name="ID_SALA", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSala;
	
	@Column(nullable = false)
	private String nome;
	private String tipoSala;
	private int nAcentos;
	
	@Column(name = "idCinema", insertable = false, updatable = false, nullable = false)
	private Long idCinema;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idCinema", referencedColumnName = "idCinema")
	private Cinema cinema;
	
	
	/* GET's & SET's*/
	
	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getnAcentos() {
		return nAcentos;
	}
	
	public void setnAcentos(int nAcentos) {
		this.nAcentos = nAcentos;
	}

	public Long getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(Long idCinema) {
		this.idCinema = idCinema;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (idSala == null) {
			if (other.idSala != null)
				return false;
		} else if (!idSala.equals(other.idSala))
			return false;
		return true;
	}	
	
	
}
