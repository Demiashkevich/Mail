package com.dzemiashkevich.mail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value="Mail Client API")
public interface ApplicationClientApi {

    @ApiOperation(value = "Returns created application in the system")
    @PostMapping(value = "/applications")
    public ResponseEntity<ApplicationRestDto> createApplication(@RequestBody ApplicationRestDto application);

    @ApiOperation(value = "Returns application status by application id")
    @GetMapping(value = "/applications/{applicationId}")
    public ResponseEntity<StatusRestDto> readApplicationStatus(@PathVariable Long applicationId);

}
