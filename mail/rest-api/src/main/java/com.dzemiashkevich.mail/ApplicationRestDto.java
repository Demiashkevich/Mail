package com.dzemiashkevich.mail;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(value = "Application")
public class ApplicationRestDto {

    @ApiModelProperty(value = "Application id", required = true)
    private Long applicationId;

    @ApiModelProperty(value = "Description of application", required = true)
    @NotEmpty
    private String description;

    @ApiModelProperty(value = "Date of application create", required = true)
    @NotNull
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "Date of application expiration", required = true)
    @NotNull
    private LocalDateTime expirationAt;

    @ApiModelProperty(value = "Status of application", required = true)
    private StatusRestDto status = StatusRestDto.OPEN;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public LocalDateTime getExpirationAt() {
        return expirationAt;
    }

    public void setExpirationAt(LocalDateTime expirationAt) {
        this.expirationAt = expirationAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StatusRestDto getStatus() {
        return status;
    }

    public void setStatus(StatusRestDto status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
