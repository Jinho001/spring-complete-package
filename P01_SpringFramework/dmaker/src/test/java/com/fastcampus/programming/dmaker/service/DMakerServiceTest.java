package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.code.StatusCode;
import com.fastcampus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.repository.RetiredDeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fastcampus.programming.dmaker.code.StatusCode.EMPLOYED;
import static com.fastcampus.programming.dmaker.type.DeveloperLevel.JUNIOR;
import static com.fastcampus.programming.dmaker.type.DeveloperLevel.SENIOR;
import static com.fastcampus.programming.dmaker.type.DeveloperSkillType.BACK_END;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DMakerServiceTest {
    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    @InjectMocks
    private DMakerService dMakerService;

    @Test
    public void testSomething(){

        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(Developer.builder()
                        .developerLevel(JUNIOR)
                        .developerSkillType(BACK_END)
                                .experienceYears(1)
                                .statusCode(EMPLOYED)
                                .name("name")
                                .age(29)
                        .build()));

        DeveloperDetailDto developerDetail = dMakerService.getDeveloperDetail("memberId");

        assertEquals(JUNIOR, developerDetail.getDeveloperLevel());
        assertEquals(BACK_END, developerDetail.getDeveloperSkillType());
        assertEquals(1, developerDetail.getExperienceYears());
    }
}