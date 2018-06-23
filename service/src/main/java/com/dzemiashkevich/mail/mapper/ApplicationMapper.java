package com.dzemiashkevich.mail.mapper;

import com.dzemiashkevich.mail.ApplicationRestDto;
import com.dzemiashkevich.mail.StatusRestDto;
import com.dzemiashkevich.mail.model.ApplicationEntity;
import com.dzemiashkevich.mail.model.StatusEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {

    ApplicationRestDto domainToDto(ApplicationEntity domain);
    List<ApplicationRestDto> domainToDto(List<ApplicationEntity> domain);
    ApplicationEntity dtoToDomain(ApplicationRestDto dto);
    List<ApplicationEntity> dtoToDomain(List<ApplicationRestDto> dto);
    StatusRestDto domainToDto(StatusEntity domain);
    StatusEntity dtoToDomain(StatusRestDto dto);

}
