package org.lvtest.football.facades.impl;

import jakarta.annotation.Resource;
import org.lvtest.football.converters.PlayerDataToPlayerModelConverter;
import org.lvtest.football.converters.PlayerModelToPlayerDataConverter;
import org.lvtest.football.datas.PlayerData;
import org.lvtest.football.facades.PlayerFacade;
import org.lvtest.football.services.PlayerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultPlayerFacade implements PlayerFacade {

    @Resource
    private PlayerService playerService;

    @Resource
    private PlayerModelToPlayerDataConverter playerModelToPlayerDataConverter;

    @Resource
    private PlayerDataToPlayerModelConverter playerDataToPlayerModelConverter;

    @Override
    public List<PlayerData> findAll() {
        return playerService.findAll()
                            .stream()
                            .map(playerModel -> playerModelToPlayerDataConverter.convert(playerModel))
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerData> findById(Long id) {
        return playerService.findById(id)
                            .map(playermodel -> playerModelToPlayerDataConverter.convert(playermodel));
    }

    @Override
    public PlayerData save(PlayerData playerData) {
        return playerModelToPlayerDataConverter.convert(playerService.save(playerDataToPlayerModelConverter.convert(playerData)));
    }

    @Override
    public void deleteById(Long id) {
        playerService.deleteById(id);
    }

    @Override
    public List<PlayerData> findByAgeBetween(int minAge, int maxAge) {
        return playerService.findByAgeBetween(minAge, maxAge)
                            .stream()
                            .map(playerModel -> playerModelToPlayerDataConverter.convert(playerModel))
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerData> findByNameIgnoreCase(String playerName) {
        return playerService.findByNameIgnoreCase(playerName)
                            .map(playerModelToPlayerDataConverter::convert);
    }
}
