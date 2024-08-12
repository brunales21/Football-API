package org.lvtest.football.daos;

import org.lvtest.football.models.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PlayerDao extends JpaRepository<PlayerModel, Long> {
    List<PlayerModel> findByAgeBetween(int min, int max);
    Optional<PlayerModel> findByNameIgnoreCase(String name);
}
