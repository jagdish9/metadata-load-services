package com.config.gitmetadataloadservice.service;

import com.config.commonevents.events.MvnMetadataLoaded;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class GitMetadataService {

    private static final Logger log = LoggerFactory.getLogger(GitMetadataService.class);

    @KafkaListener(topics = "mvn-load-topic", groupId = "git-metadata-group")
    public void consumeMvnMessage(ConsumerRecord<String, MvnMetadataLoaded> record,
                                  Acknowledgment acknowledgment) {
        String message = record.value().getMessage();
        String gavId = record.value().getGavId();
        String id = record.key();

        try {
            //process git loading data for gavId
            processGitMetadataLoad(gavId, id);

            //Save processed event to DB table

            //manual commit
            acknowledgment.acknowledge();

        } catch (Exception e) {
            log.error("Error while processing git metadata for id: {}", id);
            throw e; // Try retry
        }

    }

    private void processGitMetadataLoad(String gavId, String id) {
        //Clone git url
        //scan url and search license, notice and copying text
        //text load to kb with sha256 checksum
    }
}
