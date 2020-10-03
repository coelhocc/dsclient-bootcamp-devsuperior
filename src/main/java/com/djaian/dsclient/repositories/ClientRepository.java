package com.djaian.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djaian.dsclient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
