package com.config.mvnmetadataloadservice.controller;

import com.config.mvnmetadataloadservice.entity.Artifact;
import com.config.mvnmetadataloadservice.service.MvnMetadataLoadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mvn")
public class MvnMetadataLoadController {

    private final MvnMetadataLoadService mvnMetadataLoadService;

    public MvnMetadataLoadController(MvnMetadataLoadService mvnMetadataLoadService) {
        this.mvnMetadataLoadService = mvnMetadataLoadService;
    }

    @PostMapping
    public ResponseEntity<?> createArtifact(@RequestBody Artifact artifact) {
        return new ResponseEntity<>(mvnMetadataLoadService.createArtifact(artifact), HttpStatus.CREATED);
    }
}
