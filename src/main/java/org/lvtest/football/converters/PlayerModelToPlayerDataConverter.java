package org.lvtest.football.converters;

import org.lvtest.football.datas.PlayerData;
import org.lvtest.football.models.PlayerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerModelToPlayerDataConverter implements Converter<PlayerModel, PlayerData> {

    @Override
    public PlayerData convert(PlayerModel playerModel) {
        return PlayerData.builder()
                         .id(playerModel.getId())
                         .name(playerModel.getName())
                         .lastname(playerModel.getLastname())
                         .age(playerModel.getAge())
                         .nationality(playerModel.getNationality())
                         .team(playerModel.getTeam())
                         .build();
    }
}
