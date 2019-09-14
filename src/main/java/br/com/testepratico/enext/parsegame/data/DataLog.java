package br.com.testepratico.enext.parsegame.data;

import br.com.testepratico.enext.parsegame.domain.Death;
import br.com.testepratico.enext.parsegame.domain.Game;
import br.com.testepratico.enext.parsegame.domain.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLog {

    private static List<Game> games = new ArrayList<>();
    private static List<Death> deaths = new ArrayList<>();
    private static Map<Integer, List<Player>> ranking = new HashMap<>();

    public static List<Game> getGames() {
        return games;
    }

    public static List<Death> getDeaths() {
        return deaths;
    }

    public static Map<Integer, List<Player>> getRanking() {
        return ranking;
    }
}
