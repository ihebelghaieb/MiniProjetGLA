package tn.essat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.essat.dao.ICategorieDao;
import tn.essat.dao.IClientDao;
import tn.essat.dao.ICommandeDao;
import tn.essat.dao.ILigneCommandeDao;
import tn.essat.dao.IProduitDao;
import tn.essat.model.Categorie;
import tn.essat.model.Client;
import tn.essat.model.Commande;
import tn.essat.model.LigneCde;
import tn.essat.model.LignePanier;
import tn.essat.model.Panier;
import tn.essat.model.Produit;

@Controller
public class AppBoutique {
	@Autowired
	ICategorieDao catdao;
	@Autowired
	IProduitDao proddao;
	@Autowired
	IClientDao cltdao;
	@Autowired
	ICommandeDao cdedao;
	@Autowired
	ILigneCommandeDao licdedao;
	public void setCatdao(ICategorieDao catdao) {
		this.catdao = catdao;
	}
	public void setProddao(IProduitDao proddao) {
		this.proddao = proddao;
	}
	public void setCltdao(IClientDao cltdao) {
		this.cltdao = cltdao;
	}
	public void setCdedao(ICommandeDao cdedao) {
		this.cdedao = cdedao;
	}
	public void setLicdedao(ILigneCommandeDao licdedao) {
		this.licdedao = licdedao;
	}
    @GetMapping("/home")
	public String get1(Model m) {
		List<Categorie> liste1=catdao.findAll();
		List<Produit> liste2=proddao.findAll();
		m.addAttribute("prods",liste2);
		m.addAttribute("cats",liste1);
		return "accueil";
	}
    
    @GetMapping("/produits/{id}")
	public String get2(Model m, @PathVariable("id") int id) {
		List<Categorie> liste1=catdao.findAll();
		List<Produit> liste2=proddao.getAllProduitByCat(id);
		m.addAttribute("prods",liste2);
		m.addAttribute("cats",liste1);
		return "accueil";
	}
    @GetMapping("/addPanier/{id}")
	public String get3(Model m, @PathVariable("id") int id,HttpSession session) {
		Panier pan= (Panier) session.getAttribute("monpanier");
		if(pan==null) {
			Panier p=new Panier();
			Produit prod=proddao.findOne(id);
			p.addPanier(new LignePanier(prod,1));
			session.setAttribute("monpanier", p);
		}else {
			boolean test=false;
			for(LignePanier li:pan.getLignes()) {
				if(li.getProd().getId()==id) {
					li.setQuantite(li.getQuantite()+1);
					test=true;
				}
			}
			if(test==false) {
				Produit prod=proddao.findOne(id);
				pan.addPanier(new LignePanier(prod,1));
				
			}
			session.setAttribute("monpanier", pan);
		}
		return "redirect:/panier";
	}
    @GetMapping("/panier")
   	public String get4(Model m) {
   		List<Categorie> liste1=catdao.findAll();
   		m.addAttribute("cats",liste1);
   		return "panier";
   	}
    @GetMapping("/verif")
   	public String get5(Model m,HttpSession session,HttpServletRequest request) {
   		String email=request.getParameter("email");
   		String pass=request.getParameter("password");
   		Client clt=cltdao.verif(email, pass);
   		if(clt==null) {
   			return "redirect:/connexion";
   		}
   		else {
   			session.setAttribute("clt", clt);
   			return "redirect:/commander";
   		}
   	}
    @GetMapping("/connexion")
   	public String get6(Model m) {
   		Client clt=new Client();
   		m.addAttribute("clt",clt);
   		return "pageConnexion";
   	}
    @PostMapping("/saveClient")
   	public String get7(Model m,@ModelAttribute("clt") Client c,HttpSession session) {
   		cltdao.save(c);
   		session.setAttribute("clt",c);
   		return "redirect:/commander";
   	}
    @GetMapping("/dec")
   	public String get8(Model m,HttpSession session) {
   	session.removeAttribute("clt");
   	session.removeAttribute("monpanier");
   		return "redirect:/home";
   	}
    @GetMapping("/commander")
   	public String get9(Model m,HttpSession session) {
   Client clt=(Client) session.getAttribute("clt");
   		if(clt==null) {
   			return "redirect:/connexion";
   		}else {
   			Panier pan=(Panier) session.getAttribute("monpanier");
   			Commande cde=new Commande();
   			cde.setClt(clt);
   			cde.setDateCde("12/12/2020");
   			for(LignePanier lip:pan.getLignes()) {
   				LigneCde lic=new LigneCde();
   				lic.setProd(lip.getProd());
   				lic.setQuantite(lip.getQuantite());
   				cde.addLignes(lic);
   			}
   			cdedao.save(cde);
   			session.removeAttribute("monpanier");
   			return "fincde";
   		}
   	}
	
}
