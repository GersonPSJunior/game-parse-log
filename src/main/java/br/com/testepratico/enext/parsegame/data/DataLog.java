package br.com.testepratico.enext.parsegame.data;

import br.com.testepratico.enext.parsegame.domain.Death;
import br.com.testepratico.enext.parsegame.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class DataLog {

    private static List<Game> games = new ArrayList<>();
    private static List<Death> deaths = new ArrayList<>();

    public static List<Game> getGames() {
        return games;
    }

    public static List<Death> getDeaths() {
        return deaths;
    }
}
