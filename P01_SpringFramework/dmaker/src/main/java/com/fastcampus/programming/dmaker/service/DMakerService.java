package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.exception.DMakerErrorCode;
import com.fastcampus.programming.dmaker.exception.DMakerException;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.fastcampus.programming.dmaker.exception.DMakerErrorCode.DUPLICATED_MEMBER_ID;
import static com.fastcampus.programming.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validateCreateDeveloperRequest(request);

        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();

        developerRepository.save(developer);
        return CreateDeveloper.Response.fromEntity(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        //business validation
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();

        if(developerLevel == DeveloperLevel.SENIOR && experienceYears < 10){
            //throw new RuntimeException("SENIOR need 10 years experience.");
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if(developerLevel == DeveloperLevel.JUNGNIOR
            && (experienceYears < 4) || experienceYears >10){
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if(developerLevel == DeveloperLevel.JUNIOR && experienceYears >4){
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

//        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
//        if(developer.isPresent())
//            throw new DMakerException(DUPLICATED_MEMBER_ID);

        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer -> {
                    throw new DMakerException(DUPLICATED_MEMBER_ID);
                }));
    }


}
