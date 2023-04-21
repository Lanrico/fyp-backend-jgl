package com.backend.project.repository;

import com.backend.project.model.Media;
import com.backend.project.model.NotInterested;
import com.backend.project.model.NotInterestedId;
import com.backend.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotInterestedRepository extends JpaRepository<NotInterested, NotInterestedId> {
  Optional<NotInterested> findByUidAndMid(User user, Media media);

  List<NotInterested> findNotInterestedByUid(User user);
}