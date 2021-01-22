package kr.ac.bc.comon.springboot.endpoint.user.service;

import kr.ac.bc.comon.springboot.common.domain.*;
import kr.ac.bc.comon.springboot.common.repository.GenerationRepository;
import kr.ac.bc.comon.springboot.common.repository.UserFieldRepository;
import kr.ac.bc.comon.springboot.common.repository.UserLanguageRepository;
import kr.ac.bc.comon.springboot.common.repository.UserRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserFieldDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserLanguageDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserResponseDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final EncryptUtil encryptUtil;
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto){
        UserEntity user = userRepository.save(requestDto.toEntity(encryptUtil.encryptSHA256(requestDto.getUserId())));
        return user.getUserCd();
    }

    @Transactional(readOnly = true)
    public UserEntity findEntity(Long userCd){
        return userRepository.findByUserCd(userCd);
    }
}
