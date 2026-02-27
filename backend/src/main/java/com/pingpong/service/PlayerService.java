package com.pingpong.service;

import com.pingpong.entity.Player;
import com.pingpong.mapper.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public List<Player> findAllOrderByRanking() {
        return playerRepository.findAllOrderByRankingPointsDesc();
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    public List<Player> search(String keyword) {
        return playerRepository.findByNameContaining(keyword);
    }

    @Transactional
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Transactional
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Transactional
    public Player updateRankingPoints(Long id, Integer points) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            player.get().setRankingPoints(points);
            return playerRepository.save(player.get());
        }
        return null;
    }
}
