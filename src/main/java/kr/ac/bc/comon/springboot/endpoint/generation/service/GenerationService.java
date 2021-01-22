package kr.ac.bc.comon.springboot.endpoint.generation.service;


import kr.ac.bc.comon.springboot.common.domain.GenerationEntity;
import kr.ac.bc.comon.springboot.common.repository.GenerationRepository;
import kr.ac.bc.comon.springboot.endpoint.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GenerationService {
    private final UserService userService;

    private final GenerationRepository generationRepository;

    @Transactional
    public Boolean save(Long userCd, Integer generationNum){
        GenerationEntity generationEntity = GenerationEntity.builder()
                .userFK(userService.findEntity(userCd))
                .generationNum(generationNum)
                .generationPosition(1)
                .build();

        return Optional.ofNullable(generationRepository.save(generationEntity)).isPresent();
    }
}

