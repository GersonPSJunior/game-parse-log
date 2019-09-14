package br.com.testepratico.enext.parsegame.domain;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void setTotal_kills() {
        Game g = new Game(1);
        g.setTotal_kills(1);
        g.setTotal_kills(1);
        Assertions.assertThat(g.getTotal_kills()).isEqualTo(2);
    }

    @Test
    public void findPlayer() {
        Game g = new Game(1);
        g.addPlayer(new Player(1, "Gerson"));
        Assertions.assertThat(g.findPlayer(g.getId())!=null).isTrue();
        Assertions.assertThat(g.findPlayer(g.getId()).getName()).isEqualTo("Gerson");
    }

    @Test
    public void addPlayer() {
        Game g = new Game(1);
        g.addPlayer(new Player(1, "Gerson"));
        Assertions.assertThat(g.getPlayers()!=null).isTrue();
    }
}