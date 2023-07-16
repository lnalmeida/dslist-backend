package com.lndev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lndev.dslist.dto.GameListDTO;
import com.lndev.dslist.dto.GameProjectionDTO;
import com.lndev.dslist.dto.ReplacementDTO;
import com.lndev.dslist.services.GameListService;
import com.lndev.dslist.services.GameService;

@RestController
@RequestMapping(value="lists")
public class GameListController {
	
	@Autowired
	public GameListService gameListService;
	
	@Autowired
	public GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameProjectionDTO> findByList(@PathVariable Long listId){
		List<GameProjectionDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void replaceGamePosition(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
	
}
