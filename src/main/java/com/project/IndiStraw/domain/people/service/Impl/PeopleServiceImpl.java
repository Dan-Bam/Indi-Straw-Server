package com.project.IndiStraw.domain.people.service.Impl;

import com.project.IndiStraw.domain.people.People;
import com.project.IndiStraw.domain.people.dto.RegisterPeopleDto;
import com.project.IndiStraw.domain.people.repository.PeopleRepository;
import com.project.IndiStraw.domain.people.service.PeopleService;
import com.project.IndiStraw.global.util.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final S3Service s3Service;
    private final PeopleRepository peopleRepository;

    @Override
    public Long registerPeople(RegisterPeopleDto registerPeopleDto, MultipartFile file) {
        String imageUrl = s3Service.upload(file, "people_image/");
        People people = registerPeopleDto.toEntity(imageUrl);
        return peopleRepository.save(people).getPeople_id();
    }
}
