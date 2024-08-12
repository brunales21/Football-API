package org.lvtest.football.facades;

import org.lvtest.football.datas.PlayerData;

import java.util.List;
import java.util.Optional;

public interface PlayerFacade {

    List<PlayerData> findAll();

    Optional<PlayerData> findById(Long id);

    PlayerData save(PlayerData player);

    void deleteById(Long id);

    List<PlayerData> findByAgeBetween(int minAge, int maxAge);

    Optional<PlayerData> findByNameIgnoreCase(String playerName);

}
