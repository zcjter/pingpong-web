package com.pingpong.mapper;

import com.pingpong.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findByIsPublishedTrueOrderByCreatedAtDesc();
    List<Announcement> findByType(String type);
}
