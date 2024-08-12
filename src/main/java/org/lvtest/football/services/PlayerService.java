package org.lvtest.football.services;

import org.lvtest.football.models.PlayerModel;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerModel> findAll();

    Optional<PlayerModel> findById(Long id);

    Optional<PlayerModel> findByNameIgnoreCase(String name);

    void deleteById(Long id);

    PlayerModel save(PlayerModel player);

    List<PlayerModel> findByAgeBetween(Integer minAge, Integer maxAge);
}
