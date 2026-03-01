package com.pingpong.service;

import com.pingpong.entity.Announcement;
import com.pingpong.mapper.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
    
    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }

    public List<Announcement> findPublished() {
        return announcementRepository.findByIsPublishedTrueOrderByCreatedAtDesc();
    }

    public Optional<Announcement> findById(Long id) {
        return announcementRepository.findById(id);
    }

    @Transactional
    public Announcement save(Announcement announcement) {
        if (announcement.getId() != null) {
            Optional<Announcement> existing = announcementRepository.findById(announcement.getId());
            if (existing.isPresent()) {
                announcement.setCreatedAt(existing.get().getCreatedAt());
            }
        }
        return announcementRepository.save(announcement);
    }

    @Transactional
    public void deleteById(Long id) {
        announcementRepository.deleteById(id);
    }
}
