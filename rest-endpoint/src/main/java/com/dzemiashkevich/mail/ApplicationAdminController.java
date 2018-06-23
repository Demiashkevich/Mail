package com.dzemiashkevich.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationAdminController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "/applications")
    public ResponseEntity<List<ApplicationRestDto>> readApplication() {
        return ResponseEntity.ok(applicationService.readApplication());
    }

    @PatchMapping(value = "/applications/{applicationId}")
    public ResponseEntity<ApplicationRestDto> updateApplicationByStatus(@PathVariable Long applicationId, @RequestBody StatusRestDto status) {
        return ResponseEntity.ok(applicationService.updateApplicationByStatus(applicationId, status));
    }

    @GetMapping(value = "/applications/{status}")
    public ResponseEntity<Long> readAmountApplicationByStatus(@PathVariable StatusRestDto status) {
        return ResponseEntity.ok(applicationService.readAmountApplicationByStatus(status));
    }

}
