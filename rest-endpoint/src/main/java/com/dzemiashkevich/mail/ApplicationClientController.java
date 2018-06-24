package com.dzemiashkevich.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationClientController implements ApplicationClientApi {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping(value = "/applications")
    public ResponseEntity<ApplicationRestDto> createApplication(@RequestBody ApplicationRestDto application) {
        return ResponseEntity.ok(applicationService.createApplication(application));
    }

    @GetMapping(value = "/applications/{applicationId}")
    public ResponseEntity<StatusRestDto> readApplicationStatus(@PathVariable Long applicationId) {
        return ResponseEntity.ok(applicationService.readApplicationStatus(applicationId));
    }

}
