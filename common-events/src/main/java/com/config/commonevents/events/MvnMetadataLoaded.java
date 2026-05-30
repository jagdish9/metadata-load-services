package com.config.commonevents.events;

public class MvnMetadataLoaded {
    private String eventId;
    private String gavId;
    private String status;
    private String message;

    public MvnMetadataLoaded() {}

    public MvnMetadataLoaded(String eventId, String gavId, String status, String message) {
        this.eventId = eventId;
        this.gavId = gavId;
        this.status = status;
        this.message = message;
    }

    public String getGavId() {
        return gavId;
    }

    public void setGavId(String gavId) {
        this.gavId = gavId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
