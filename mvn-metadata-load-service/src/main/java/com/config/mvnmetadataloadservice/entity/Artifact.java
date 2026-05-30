package com.config.mvnmetadataloadservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "artifact_basic_metadata")
@Getter
@Setter
public class Artifact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String groupId;
    private String artifactName;
    private String version;
    private String latestVersion;
}
