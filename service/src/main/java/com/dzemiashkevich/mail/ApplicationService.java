package com.dzemiashkevich.mail;

import com.dzemiashkevich.mail.mapper.ApplicationMapper;
import com.dzemiashkevich.mail.model.ApplicationEntity;
import com.dzemiashkevich.mail.model.StatusEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private ApplicationMapper applicationMapper = Mappers.getMapper(ApplicationMapper.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<ApplicationRestDto> readApplication() {
        List<ApplicationEntity> applications = applicationRepository.findAll();
        return applicationMapper.domainToDto(applications);
    }

    public ApplicationRestDto updateApplicationByStatus(Long applicationId, StatusRestDto status) {
        ApplicationEntity entity = Optional.of(applicationRepository.findOne(applicationId))
                .map(e -> {
                    ApplicationEntity updatedEntity = this.updateStatus(e, status);
                    return applicationRepository.save(updatedEntity);
                }).orElseThrow(RuntimeException::new);
        return applicationMapper.domainToDto(entity);
    }

    private ApplicationEntity updateStatus(ApplicationEntity applicationEntity, StatusRestDto status) {
        StatusEntity statusEntity = applicationMapper.dtoToDomain(status);
        applicationEntity.setStatus(statusEntity);
        return applicationEntity;
    }

    public Long readAmountApplicationByStatus(StatusRestDto status) {
        StatusEntity statusEntity = applicationMapper.dtoToDomain(status);
        return applicationRepository.countApplicationByStatus(statusEntity)
                .map(c -> c)
                .orElseThrow(RuntimeException::new);
    }

}
