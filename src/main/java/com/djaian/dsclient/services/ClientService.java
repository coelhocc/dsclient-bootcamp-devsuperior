package com.djaian.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djaian.dsclient.entities.Client;
import com.djaian.dsclient.entities.dto.ClientDTO;
import com.djaian.dsclient.repositories.ClientRepository;
import com.djaian.dsclient.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list =  repository.findAll();
		
		return list.stream().map(cli -> new ClientDTO(cli)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> cliObj = repository.findById(id);
		Client entity = cliObj.orElseThrow(() -> new ResourceNotFoundException("ID not found " + id));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToClient(dto, entity);
		entity = repository.save(entity);
		
		return new ClientDTO(entity);
	}

	private void copyDtoToClient(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
}
