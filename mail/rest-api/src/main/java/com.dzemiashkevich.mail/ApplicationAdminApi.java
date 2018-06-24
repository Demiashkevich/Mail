package com.dzemiashkevich.mail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(value="Mail Admin API")
public interface ApplicationAdminApi {

    @ApiOperation(value = "Returns list of all existing applications in the system")
    public ResponseEntity<List<ApplicationRestDto>> readApplication();

    @ApiOperation(value = "Returns updated application by application id")
    public ResponseEntity<ApplicationRestDto> updateApplicationByStatus(Long applicationId, StatusRestDto status);

    @ApiOperation(value = "Returns amount of application by status")
    public ResponseEntity<Long> readAmountApplicationByStatus(StatusRestDto status);

}
