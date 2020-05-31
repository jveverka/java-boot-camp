package com.java.bootcamp.projects.spring.springjunit.controller;

import com.java.bootcamp.projects.spring.springjunit.config.AppConfig;
import com.java.bootcamp.projects.spring.springjunit.dto.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    private final AppConfig appConfig;

    public SystemController(@Autowired AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/info")
    public ResponseEntity<SystemInfo> getSystemInfo() {
        return ResponseEntity.ok(new SystemInfo(appConfig.getId(), "test-app", System.currentTimeMillis()));
    }

}
