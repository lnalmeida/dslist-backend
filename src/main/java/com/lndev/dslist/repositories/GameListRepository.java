package com.lndev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lndev.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{

}
