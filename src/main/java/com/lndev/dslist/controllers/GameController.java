package com.lndev.dslist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lndev.dslist.dto.GameDTO;
import com.lndev.dslist.dto.GameMinDTO;
import com.lndev.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAllGames(){
		List<GameMinDTO> result = gameService.findAllGames();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> findGameById(@PathVariable Long id) {
		Optional<GameDTO> result = gameService.findGameById(id);
		if(result.isPresent()) {
			return ResponseEntity.ok(result.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
