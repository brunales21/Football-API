package org.lvtest.football.controllers;

import jakarta.annotation.Resource;
import org.lvtest.football.datas.PlayerData;
import org.lvtest.football.facades.PlayerFacade;
import org.lvtest.football.models.PlayerModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Resource
    private PlayerFacade playerFacade;

    @GetMapping("/players")
    public ResponseEntity<List<PlayerData>> getAllPlayers() {
        return ResponseEntity.ok(playerFacade.findAll());
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerData> getPlayerById(@PathVariable Long id) {
        Optional<PlayerData> player = playerFacade.findById(id);
        return player.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/players")
    public ResponseEntity<PlayerData> createPlayer(@RequestBody PlayerData playerData) {
        return ResponseEntity.ok(playerFacade.save(playerData));
    }


}
