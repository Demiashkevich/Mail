package com.dzemiashkevich.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ApplicationClientController implements ApplicationClientApi {

    @Autowired
    private ApplicationService applicationService;

    public ResponseEntity<ApplicationRestDto> createApplication(@RequestBody @Valid ApplicationRestDto application) {
        return ResponseEntity.ok(applicationService.createApplication(application));
    }

    public ResponseEntity<StatusRestDto> readApplicationStatus(@PathVariable Long applicationId) {
        return ResponseEntity.ok(applicationService.readApplicationStatus(applicationId));
    }

}
