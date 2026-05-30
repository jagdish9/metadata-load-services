package com.config.mvnmetadataloadservice.repository;

import com.config.mvnmetadataloadservice.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvnMetadataLoadRepository extends JpaRepository<Artifact, Long> {
}
