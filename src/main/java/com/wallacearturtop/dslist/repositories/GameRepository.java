package com.wallacearturtop.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallacearturtop.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game,Long>{

	
}
