package com.dzemiashkevich.mail.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
public class ApplicationEntity {

    @Id
    @GeneratedValue
    private Long applicationId;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "expiration_at")
    private LocalDateTime expirationAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEntity status;

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public LocalDateTime getExpirationAt() {
        return expirationAt;
    }

    public void setExpirationAt(LocalDateTime expirationAt) {
        this.expirationAt = expirationAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
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
