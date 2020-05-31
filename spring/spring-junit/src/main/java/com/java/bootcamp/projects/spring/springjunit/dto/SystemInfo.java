package com.java.bootcamp.projects.spring.springjunit.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemInfo {

    private final String appId;
    private final String appName;
    private final Long timeStamp;

    @JsonCreator
    public SystemInfo(@JsonProperty("appId") String appId,
                      @JsonProperty("appName") String appName,
                      @JsonProperty("timeStamp") Long timeStamp) {
        this.appId = appId;
        this.appName = appName;
        this.timeStamp = timeStamp;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppName() {
        return appName;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

}
