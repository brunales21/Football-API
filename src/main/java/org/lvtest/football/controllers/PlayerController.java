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


    @PutMapping("/players/{id}")
    public ResponseEntity<PlayerData> updatePlayer(@PathVariable Long id, @RequestBody PlayerData playerData) {
        if (playerFacade.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        playerData.setId(id);
        return ResponseEntity.ok(playerFacade.save(playerData));
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        if (playerFacade.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        playerFacade.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
