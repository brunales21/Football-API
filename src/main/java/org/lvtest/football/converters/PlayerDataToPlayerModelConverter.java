package org.lvtest.football.converters;

import org.lvtest.football.datas.PlayerData;
import org.lvtest.football.models.PlayerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerDataToPlayerModelConverter implements Converter<PlayerData, PlayerModel> {

    @Override
    public PlayerModel convert(PlayerData playerData) {
        return PlayerModel.builder()
                          .id(playerData.getId())
                          .name(playerData.getName())
                          .age(playerData.getAge())
                          .team(playerData.getTeam())
                          .lastname(playerData.getLastname())
                          .nationality(playerData.getNationality())
                          .build();
    }
}
