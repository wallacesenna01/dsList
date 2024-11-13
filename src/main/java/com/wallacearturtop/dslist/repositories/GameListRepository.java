package com.wallacearturtop.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallacearturtop.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{

	
}
