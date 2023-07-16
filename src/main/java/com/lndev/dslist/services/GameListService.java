package com.lndev.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lndev.dslist.dto.GameListDTO;
import com.lndev.dslist.entities.GameList;
import com.lndev.dslist.projections.GameMinProjection;
import com.lndev.dslist.repositories.GameListRepository;
import com.lndev.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).collect(Collectors.toList());
	} 
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection movedGame = list.remove(sourceIndex);
		list.add(destinationIndex, movedGame);
		
		int min = sourceIndex <  destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++ ) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}		
	}
}
