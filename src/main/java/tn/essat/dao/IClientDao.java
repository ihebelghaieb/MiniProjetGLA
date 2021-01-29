package tn.essat.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.essat.model.Client;

@Repository
public interface IClientDao extends JpaRepository<Client, Integer>{
	 @Query("select c from Client c where c.email=?1 and c.password=?2")
     public Client verif(String email,String mp);
}