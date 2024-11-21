package com.wallacearturtop.dslist.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.wallacearturtop.dslist.dto.GameDTO;
import com.wallacearturtop.dslist.dto.GameMinDTO;
import com.wallacearturtop.dslist.entities.Game;
import com.wallacearturtop.dslist.projections.GameMinProjection;
import com.wallacearturtop.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
	    try {
	        Game result = gameRepository.findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found for ID: " + id));
	        return new GameDTO(result);
	    } catch (ResponseStatusException e) {
	        // Trata o erro 404 explicitamente
	        throw e;
	    } catch (Exception e) {
	        // Trata qualquer outro erro inesperado
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred", e);
	    }
	}

	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {		
       List <Game> result = gameRepository.findAll();
       return result.stream().map(x -> new GameMinDTO(x)).toList();
               
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {		
		List<GameMinProjection> result = gameRepository.searchByList(listId);
       return result.stream().map(x -> new GameMinDTO(x)).toList();
               
	}
	
}
