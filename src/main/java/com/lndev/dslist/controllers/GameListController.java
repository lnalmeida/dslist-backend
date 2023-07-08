package com.lndev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lndev.dslist.dto.GameListDTO;
import com.lndev.dslist.services.GameListService;

@RestController
@RequestMapping(value="list")
public class GameListController {
	
	@Autowired
	public GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
