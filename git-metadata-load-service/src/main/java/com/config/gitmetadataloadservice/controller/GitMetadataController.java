package com.config.gitmetadataloadservice.controller;

import com.config.gitmetadataloadservice.service.GitMetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitMetadataController {

    private final GitMetadataService gitMetadataService;

    public GitMetadataController(GitMetadataService gitMetadataService) {
        this.gitMetadataService = gitMetadataService;
    }

    @PostMapping
    public ResponseEntity<?> loadGitMetadata(@RequestParam String gavId) {
        return null;
    }
}
