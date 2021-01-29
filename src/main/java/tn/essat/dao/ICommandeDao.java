package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.essat.model.Commande;

@Repository
public interface ICommandeDao extends JpaRepository<Commande, Integer>{
     @Query("select c from Commande c where c.clt.id=?1")
     public List<Commande> getAllCommandeByClient(int id);
}