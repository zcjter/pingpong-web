package com.pingpong.mapper;

import com.pingpong.entity.PlayerRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRankingRepository extends JpaRepository<PlayerRanking, Long> {
    List<PlayerRanking> findByRankingYearOrderByRankingAsc(Integer rankingYear);
    List<PlayerRanking> findAllByOrderByRankingYearDescRankingAsc();
    List<PlayerRanking> findByRankingYearAndCategoryOrderByRankingAsc(Integer rankingYear, String category);
    List<PlayerRanking> findByCategoryOrderByRankingYearDescRankingAsc(String category);
}
