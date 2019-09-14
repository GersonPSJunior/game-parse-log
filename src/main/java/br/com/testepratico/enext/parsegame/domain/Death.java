package br.com.testepratico.enext.parsegame.domain;

import br.com.testepratico.enext.parsegame.domain.enums.TypeDeath;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Death implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> kills_by_means = new HashMap<>();

    public Death() {
    }

    public Map<String, Integer> getKills_by_means() {
        return kills_by_means;
    }

    public void putKill(Integer id){
        TypeDeath typeDeath = TypeDeath.toEnum(id);
        if (kills_by_means.containsKey(typeDeath.getDescricao())){
            kills_by_means.merge(typeDeath.getDescricao(), 1, Integer::sum);
        } else {
            kills_by_means.put(typeDeath.getDescricao(), 1);
        }
    }

    @Override
    public String toString() {
        return "Death{" +
                "kills_by_means=" + kills_by_means +
                '}';
    }
}
