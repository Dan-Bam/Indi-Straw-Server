package com.project.IndiStraw.domain.movie.repository;

import com.project.IndiStraw.domain.movie.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
