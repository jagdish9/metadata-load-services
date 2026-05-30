package com.config.mvnmetadataloadservice.service;

import com.config.commonevents.events.MvnMetadataLoaded;
import com.config.mvnmetadataloadservice.entity.Artifact;
import com.config.mvnmetadataloadservice.repository.MvnMetadataLoadRepository;
import com.config.mvnmetadataloadservice.status.LoadStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MvnMetadataLoadService {

    private static final Logger log = LoggerFactory.getLogger(MvnMetadataLoadService.class);

    private final MvnMetadataLoadRepository mvnMetadataLoadRepository;

    private final KafkaTemplate<String, MvnMetadataLoaded> kafkaTemplate;

    @Value("${topic.mvn-loaded}")
    private String mvnLoadTopic;

    public MvnMetadataLoadService(MvnMetadataLoadRepository mvnMetadataLoadRepository,
                                  KafkaTemplate<String, MvnMetadataLoaded> kafkaTemplate) {
        this.mvnMetadataLoadRepository = mvnMetadataLoadRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Artifact createArtifact(Artifact artifact) {
        Artifact loaded = mvnMetadataLoadRepository.save(artifact);

        log.info("Mvn data loaded successfully");

        String gavId = artifact.getGroupId() + ":" + artifact.getArtifactName() + ":" + artifact.getVersion();
        kafkaTemplate.send(mvnLoadTopic, String.valueOf(loaded.getId()),
                new MvnMetadataLoaded(String.valueOf(loaded.getId()),
                        gavId, LoadStatus.LOADED.name(),
                        "Mvn metadata loaded successfully"));
        log.info("Message published to the topic successfully");

        return loaded;
    }
}
