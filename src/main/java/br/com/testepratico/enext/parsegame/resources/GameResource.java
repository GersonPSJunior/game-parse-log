package br.com.testepratico.enext.parsegame.resources;

import br.com.testepratico.enext.parsegame.domain.Game;
import br.com.testepratico.enext.parsegame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

    @Autowired
    private GameRepository repository;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Game> find(@PathVariable Integer id){
        Game game = repository.find(id);
        return ResponseEntity.ok().body(game);
    }

    @RequestMapping
    public ResponseEntity<List<Game>> findAll(){
        List<Game> game = repository.findAll();
        return ResponseEntity.ok().body(game);
    }

}
