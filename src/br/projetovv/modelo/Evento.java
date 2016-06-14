package br.projetovv.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.projetovv.stub.Filme;
import br.projetovv.modelo.Sala;

@Entity(name = "evento")
public class Evento {

	@Id
	@Column(name = "ID_EVENTO", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @ManyToOne(optional = false)
	@Column(name = "ID_FILME" ,insertable = false, updatable = false, nullable = false)
	private Long idFilme;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_FILME", referencedColumnName = "ID_FILME")
	private Filme filme;

	@Column(name = "ID_SALA", insertable = false, updatable = false, nullable = false)
	private Long idSala;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
	private Sala sala;

	@Column(name = "DATA_EVENTO")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataEvento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
