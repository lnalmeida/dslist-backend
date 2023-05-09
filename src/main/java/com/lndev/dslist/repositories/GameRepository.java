package com.lndev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lndev.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
}
