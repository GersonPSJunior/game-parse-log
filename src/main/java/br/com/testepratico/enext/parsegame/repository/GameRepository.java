package br.com.testepratico.enext.parsegame.repository;

import br.com.testepratico.enext.parsegame.data.DataLog;
import br.com.testepratico.enext.parsegame.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRepository {

    public Game find(Integer id){
        for (Game obj : DataLog.getGames()) {
            if (obj.getId().equals(id)) return obj;
        }
        return null;
    }

    public List<Game> findAll() {
        return DataLog.getGames();
    }
}
