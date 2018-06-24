package com.dzemiashkevich.mail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

@Api(value="Mail Client API")
public interface ApplicationClientApi {

    @ApiOperation(value = "Returns created application in the system")
    public ResponseEntity<ApplicationRestDto> createApplication(ApplicationRestDto application);

    @ApiOperation(value = "Returns application status by application id")
    public ResponseEntity<StatusRestDto> readApplicationStatus(Long applicationId);

}
