package com.dzemiashkevich.mail;

import com.dzemiashkevich.mail.model.ApplicationEntity;
import com.dzemiashkevich.mail.model.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    Optional<Long> countApplicationByStatus(StatusEntity status);

}
