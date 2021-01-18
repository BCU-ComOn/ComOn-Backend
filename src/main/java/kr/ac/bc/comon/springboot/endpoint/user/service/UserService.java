package kr.ac.bc.comon.springboot.endpoint.user.service;

import kr.ac.bc.comon.springboot.common.repository.UserRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserResponseDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final EncryptUtil encryptUtil;
    private final UserRepository userRepository;

    @Transactional
    public Integer save(UserSaveRequestDto requestDto) {
        Integer userCd = userRepository.save(requestDto.toEntity(encryptUtil.encryptSHA256(requestDto.getUserId()))).getUserCd();
        if (requestDto.getUserField() != null) {

        }
        if (requestDto.getUserLanguage() != null) {

        }

        return userCd;
    }
}
