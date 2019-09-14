package br.com.testepratico.enext.parsegame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Integer id;
    private Integer total_kills = 0;
    private List<Player> players = new ArrayList<>();
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
        this.total_kills += total_kills;
    }

    public List<String> getPlayers() {
        return players.stream().map(Player::getName).collect(Collectors.toList());
    }

    public Player findPlayer(Integer id){
        for (Player obj : players) {
            if (obj.getId().equals(id)) return obj;
        }
        return null;
    }
    public void addPlayer(Player player) {
        for (Player obj : players) {
            if(obj.getId().equals(player.getId())){
                obj.setName(player.getName());
                return;
            }
        }
        this.players.add(player);
    }

    public Map<String, Integer> getKills() {
        return kills;
    }

    public void putKills(){
        players.forEach(obj -> kills.put(obj.getName(), obj.getKill()));
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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", total_kills=" + total_kills +
                ", players=" + players +
                ", kills=" + kills +
                '}';
    }
}
