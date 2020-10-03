package com.djaian.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djaian.dsclient.entities.Client;
import com.djaian.dsclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
}
