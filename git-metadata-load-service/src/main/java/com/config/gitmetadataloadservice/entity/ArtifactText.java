package com.config.gitmetadataloadservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Clob;

@Entity
@Table(name = "artifact_text")
@Getter
@Setter
public class ArtifactText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String textType;
    private int textId;
    private Clob gitText;
    private String checksum;
}
