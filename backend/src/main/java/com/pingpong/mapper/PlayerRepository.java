package com.pingpong.mapper;

import com.pingpong.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByNameContaining(String name);
    
    @Query("SELECT p FROM Player p ORDER BY p.rankingPoints DESC")
    List<Player> findAllOrderByRankingPointsDesc();
}
