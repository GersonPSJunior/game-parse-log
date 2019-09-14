package br.com.testepratico.enext.parsegame.util;

import br.com.testepratico.enext.parsegame.domain.Game;
import br.com.testepratico.enext.parsegame.domain.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParseUtil {

    public static List<Game> readText(Stream<String> linhas) throws JsonProcessingException {
        AtomicInteger id = new AtomicInteger(1);
        List<Game> games = new ArrayList<>();
        linhas.forEach(linha -> {
            ruleInitGame(id, games, linha);
            rulePlayes(games, linha);
            ruleKill(games, linha);
        });
        games.forEach(Game::putKills);
        return games;
    }

    private static void ruleKill(List<Game> games, String linha) {
        if (linha.contains("Kill:")){
            games.get(games.size()-1).setTotal_kills(1);
            String dataKill = linha.substring(linha.indexOf("l: ")).replace("l: ", "").trim();
            if (dataKill.startsWith("1022")){
                Integer idPlayer = Integer.valueOf(dataKill.substring(5,6));
                games.get(games.size()-1).findPlayer(idPlayer).setKill(-1);
            } else {
                Integer idPlayer = Integer.valueOf(dataKill.substring(0, 1));
                games.get(games.size() - 1).findPlayer(idPlayer).setKill(1);
            }
        }
    }

    private static void rulePlayes(List<Game> games, String linha) {
        if (linha.contains("ClientUserinfoChanged:")) {
            String player = linha.substring(linha.lastIndexOf(":")+1,
                    linha.indexOf("\\t\\"));
            String[] splitPlayer = player.split(" n");
            games.get(games.size()-1).addPlayer(new Player(Integer.valueOf(splitPlayer[0].trim()),
                    splitPlayer[1].replace("\\", "").trim()));
        }
    }

    private static void ruleInitGame(AtomicInteger id, List<Game> games, String linha) {
        if (linha.contains("InitGame")) {
            games.add(new Game(id.get()));
            id.getAndIncrement();
        }
    }
}
