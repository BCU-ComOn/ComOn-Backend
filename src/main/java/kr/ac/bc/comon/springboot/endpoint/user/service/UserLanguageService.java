package kr.ac.bc.comon.springboot.endpoint.user.service;

import kr.ac.bc.comon.springboot.common.domain.UserLanguageEntity;
import kr.ac.bc.comon.springboot.common.repository.UserLanguageRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserLanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserLanguageService {

    private final UserService userService;

    private final UserLanguageRepository userLanguageRepository;

    @Transactional
    public  Boolean save(Long userCd, String languageNm){
       UserLanguageEntity userLanguageEntity = UserLanguageEntity.builder()
                .userFK(userService.findEntity(userCd))
                .languageNmFK(languageNm)
                .build();

        return Optional.ofNullable( userLanguageRepository.save(userLanguageEntity)).isPresent();
    }

}
