package com.dzemiashkevich.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationAdminController implements ApplicationAdminApi {

    @Autowired
    private ApplicationService applicationService;


    public ResponseEntity<List<ApplicationRestDto>> readApplication() {
        return ResponseEntity.ok(applicationService.readApplication());
    }

    public ResponseEntity<ApplicationRestDto> updateApplicationByStatus(@PathVariable Long applicationId, @RequestParam StatusRestDto status) {
        return ResponseEntity.ok(applicationService.updateApplicationByStatus(applicationId, status));
    }

    public ResponseEntity<Long> readAmountApplicationByStatus(@RequestParam StatusRestDto status) {
        return ResponseEntity.ok(applicationService.readAmountApplicationByStatus(status));
    }

}
