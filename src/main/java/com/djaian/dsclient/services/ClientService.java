package com.djaian.dsclient.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djaian.dsclient.entities.Client;
import com.djaian.dsclient.entities.dto.ClientDTO;
import com.djaian.dsclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<ClientDTO> findAll() {
		List<Client> list =  repository.findAll();
		
		return list.stream().map(cli -> new ClientDTO(cli)).collect(Collectors.toList());
	}
}
