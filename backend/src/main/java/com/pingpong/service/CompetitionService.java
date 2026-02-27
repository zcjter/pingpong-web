package com.pingpong.service;

import com.pingpong.entity.Competition;
import com.pingpong.entity.Match;
import com.pingpong.mapper.CompetitionRepository;
import com.pingpong.mapper.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {
    
    @Autowired
    private CompetitionRepository competitionRepository;
    
    @Autowired
    private MatchRepository matchRepository;

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public List<Competition> findActive() {
        return competitionRepository.findByIsActiveTrueOrderByStartDateDesc();
    }

    public Optional<Competition> findById(Long id) {
        return competitionRepository.findById(id);
    }

    @Transactional
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Transactional
    public void deleteById(Long id) {
        List<Match> matches = matchRepository.findByCompetitionId(id);
        matchRepository.deleteAll(matches);
        competitionRepository.deleteById(id);
    }
}
