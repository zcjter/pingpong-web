package com.pingpong.mapper;

import com.pingpong.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByStatus(String status);
    List<Match> findByCompetitionId(Long competitionId);
    void deleteByCompetitionId(Long competitionId);
}
