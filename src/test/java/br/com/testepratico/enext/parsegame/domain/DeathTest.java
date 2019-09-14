package br.com.testepratico.enext.parsegame.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeathTest {

    @Test
    public void putKill() {
        Death death = new Death();
        death.putKill(1);
        Assertions.assertThat(death.getKills_by_means()!=null).isTrue();
    }
}