package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCde {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Produit prod;
	private int quantite;
	@ManyToOne
	@JoinColumn(name = "cde_id")
	private Commande cde;
	public LigneCde() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCde(Integer id, Produit prod, int quantite, Commande cde) {
		super();
		this.id = id;
		this.prod = prod;
		this.quantite = quantite;
		this.cde = cde;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Produit getProd() {
		return prod;
	}
	public void setProd(Produit prod) {
		this.prod = prod;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Commande getCde() {
		return cde;
	}
	public void setCde(Commande cde) {
		this.cde = cde;
	}
	
	

}
