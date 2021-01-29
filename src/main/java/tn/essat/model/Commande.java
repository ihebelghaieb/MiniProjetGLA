package tn.essat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String dateCde;
	@ManyToOne
	@JoinColumn(name = "clt_id")
	private Client clt;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cde")
	private List<LigneCde> lignes;
	
	public void addLignes(LigneCde li) {
		li.setCde(this);
		this.lignes.add(li);
	}

	public Commande() {
		super();
		this.lignes = new ArrayList<LigneCde>();
	}

	public Commande(Integer id, String dateCde, Client clt, List<LigneCde> lignes) {
		super();
		this.id = id;
		this.dateCde = dateCde;
		this.clt = clt;
		this.lignes = new ArrayList<LigneCde>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateCde() {
		return dateCde;
	}

	public void setDateCde(String dateCde) {
		this.dateCde = dateCde;
	}

	public Client getClt() {
		return clt;
	}

	public void setClt(Client clt) {
		this.clt = clt;
	}

	public List<LigneCde> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCde> lignes) {
		this.lignes = lignes;
	}

}
