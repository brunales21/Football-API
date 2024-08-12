package org.lvtest.football.services.impl;

import lombok.RequiredArgsConstructor;
import org.lvtest.football.daos.PlayerDao;
import org.lvtest.football.models.PlayerModel;
import org.lvtest.football.services.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultPlayerService implements PlayerService {

    private final PlayerDao playerDao;

    @Override
    public List<PlayerModel> findAll() {
        return playerDao.findAll();
    }

    @Override
    public Optional<PlayerModel> findById(Long id) {
        return playerDao.findById(id);
    }

    @Override
    public Optional<PlayerModel> findByNameIgnoreCase(String name) {
        return playerDao.findByNameIgnoreCase(name);
    }

    @Override
    public void deleteById(Long id) {
        playerDao.deleteById(id);
    }

    @Override
    public PlayerModel save(PlayerModel player) {
        return playerDao.save(player);
    }

    @Override
    public List<PlayerModel> findByAgeBetween(Integer minAge, Integer maxAge) {
        return playerDao.findByAgeBetween(minAge, maxAge);
    }
}
