package br.projetovv.stub;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.projetovv.modelo.Evento;

@Entity(name = "filme")
public class Filme {

	@Id
	@Column(name = "ID_FILME", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFilme;

	@Column(name = "NOME_FILME", nullable = false)
	private String nomeFilme;

	@OneToMany(mappedBy = "filme", targetEntity = Evento.class, fetch = FetchType.LAZY)
	private List<Evento> eventos;

	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

}
