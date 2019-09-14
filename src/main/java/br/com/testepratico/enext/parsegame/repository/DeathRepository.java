package br.com.testepratico.enext.parsegame.repository;

import br.com.testepratico.enext.parsegame.data.DataLog;
import br.com.testepratico.enext.parsegame.domain.Death;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeathRepository {

    public List<Death> findAll() {
        return DataLog.getDeaths();
    }
}
