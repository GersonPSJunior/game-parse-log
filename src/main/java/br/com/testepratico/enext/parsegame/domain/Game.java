package br.com.testepratico.enext.parsegame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Integer id;
    private Integer total_kills;
    private List<String> players = new ArrayList<>();
    private Map<String, Integer> kills = new HashMap<>();

    public Game() {
    }

    public Game(Integer id) {
        this.id = id;
    }

    public Integer getTotal_kills() {
        return total_kills;
    }

    public void setTotal_kills(Integer total_kills) {
        this.total_kills = total_kills;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player.getName());
    }

    public Map<String, Integer> getKills() {
        return kills;
    }

    public void putKills(Player player){
        kills.put(player.getName(), player.getKill());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
