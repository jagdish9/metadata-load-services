package com.config.gitmetadataloadservice.repository;

import com.config.gitmetadataloadservice.entity.ArtifactText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitMetadataRepository extends JpaRepository<ArtifactText, Long> {
}
