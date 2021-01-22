package kr.ac.bc.comon.springboot.endpoint.user.service;

import kr.ac.bc.comon.springboot.common.domain.UserFieldEntity;
import kr.ac.bc.comon.springboot.common.repository.UserFieldRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserFieldDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserFieldService {

    private final UserService userService;

    private final UserFieldRepository userFieldRepository;

    @Transactional
    public Boolean save(Long userCd, String fieldNm){
        UserFieldEntity userFieldEntity = UserFieldEntity.builder()
                .userFK(userService.findEntity(userCd))
                .fieldNmFK(fieldNm)
                .build();

        return Optional.ofNullable(userFieldRepository.save(userFieldEntity)).isPresent();
    }
}
