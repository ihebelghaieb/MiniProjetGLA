package tn.essat.model;

public class LignePanier {
	
	private Produit prod;
	private int quantite;
	public LignePanier(Produit prod, int quantite) {
		super();
		this.prod = prod;
		this.quantite = quantite;
	}
	public LignePanier() {
		super();
		// TODO Auto-generated constructor stub
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
	

}
