package kr.ac.bc.comon.springboot.endpoint.user.service;

import kr.ac.bc.comon.springboot.common.domain.*;
import kr.ac.bc.comon.springboot.common.repository.UserRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserProfileResponseDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService {

    private final EncryptUtil encryptUtil;
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity()).getUserCd();
    }

    @Transactional
    public UserProfileResponseDto getUserProfile(String userId){
        UserEntity userEntity = Optional.ofNullable(userRepository.findByUserId(userId))
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + userId));

        UserProfileResponseDto userProfileResponseDto =  new UserProfileResponseDto(userEntity);

        List<GenerationEntity> generationEntities = userEntity.getGenerationUsers();
        userProfileResponseDto.setUserPosition(Collections.max(generationEntities, Comparator.comparing(BaseTime::getCreatedDate)).getGenerationPosition());

        return userProfileResponseDto;
    }

    @Transactional(readOnly = true)
    public UserEntity findEntity(Long userCd){
        return userRepository.findByUserCd(userCd);
    }
}
