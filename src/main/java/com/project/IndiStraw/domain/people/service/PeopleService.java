package com.project.IndiStraw.domain.people.service;

import com.project.IndiStraw.domain.people.dto.RegisterPeopleDto;
import org.springframework.web.multipart.MultipartFile;

public interface PeopleService {

    Long registerPeople(RegisterPeopleDto registerPeopleDto, MultipartFile file);
}
