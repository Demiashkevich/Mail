package com.dzemiashkevich.mail;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "mail/api/v1")
public class ApplicationAdminController {

    @GetMapping(value = "/applications")
    public ResponseEntity<List<ApplicationRestDto>> readApplication() {
        List<ApplicationRestDto> applications = new ArrayList<ApplicationRestDto>();
        return ResponseEntity.ok(applications);
    }

    @PatchMapping(value = "/applications/{applicationId}")
    public ResponseEntity<ApplicationRestDto> updateApplicationByStatus(@RequestParam Long applicationId, @RequestBody StatusRestDto status) {
        return ResponseEntity.ok(new ApplicationRestDto());
    }

    @GetMapping(value = "/applications/{status}")
    public ResponseEntity<Long> readAmountApplicationByStatus() {
        return ResponseEntity.ok(1L);
    }

}
