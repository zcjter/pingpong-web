package com.pingpong.service;

import com.pingpong.entity.PlayerRanking;
import com.pingpong.mapper.PlayerRankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerRankingService {
    
    @Autowired
    private PlayerRankingRepository playerRankingRepository;

    public List<PlayerRanking> findAll() {
        return playerRankingRepository.findAllByOrderByRankingYearDescRankingAsc();
    }

    public List<PlayerRanking> findByYear(Integer year) {
        return playerRankingRepository.findByRankingYearOrderByRankingAsc(year);
    }

    public List<PlayerRanking> findByYearAndCategory(Integer year, String category) {
        return playerRankingRepository.findByRankingYearAndCategoryOrderByRankingAsc(year, category);
    }

    public List<PlayerRanking> findByCategory(String category) {
        return playerRankingRepository.findByCategoryOrderByRankingYearDescRankingAsc(category);
    }

    public Optional<PlayerRanking> findById(Long id) {
        return playerRankingRepository.findById(id);
    }

    @Transactional
    public PlayerRanking save(PlayerRanking ranking) {
        return playerRankingRepository.save(ranking);
    }

    @Transactional
    public void deleteById(Long id) {
        playerRankingRepository.deleteById(id);
    }

    public List<Integer> getYears() {
        List<PlayerRanking> all = playerRankingRepository.findAll();
        return all.stream()
                .map(PlayerRanking::getRankingYear)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
