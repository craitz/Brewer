package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.service.Exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Estilo já cadastrado!");
		}
		
		return estilos.saveAndFlush(estilo);
	}
	
}
