package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.LigneCde;
@Repository
public interface ILigneCommandeDao extends JpaRepository<LigneCde, Integer>{

}
