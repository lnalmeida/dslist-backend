package com.lndev.dslist.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lndev.dslist.dto.GameDTO;
import com.lndev.dslist.dto.GameMinDTO;
import com.lndev.dslist.entities.Game;
import com.lndev.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameMinDTO> findAllGames(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
		
	}
	@Transactional(readOnly = true)
	public Optional<GameDTO> findGameById(Long id) {
		return gameRepository.findById(id).map(GameDTO::new);
	} 
}
