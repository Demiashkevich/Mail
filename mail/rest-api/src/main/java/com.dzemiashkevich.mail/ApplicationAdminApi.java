package com.dzemiashkevich.mail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="Mail Admin API")
public interface ApplicationAdminApi {

    @ApiOperation(value = "Returns list of all existing applications in the system")
    @GetMapping(value = "/applications")
    public ResponseEntity<List<ApplicationRestDto>> readApplication();

    @ApiOperation(value = "Returns updated application by application id")
    @PatchMapping(value = "/applications/{applicationId}")
    public ResponseEntity<ApplicationRestDto> updateApplicationByStatus(@PathVariable Long applicationId, @RequestParam StatusRestDto status);

    @ApiOperation(value = "Returns amount of application by status")
    @GetMapping(value = "/applications/amount")
    public ResponseEntity<Long> readAmountApplicationByStatus(@RequestParam StatusRestDto status);

}
