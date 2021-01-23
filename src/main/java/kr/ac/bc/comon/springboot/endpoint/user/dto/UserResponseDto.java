package kr.ac.bc.comon.springboot.endpoint.user.dto;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long userCd;
    private String userNm;
    private String userPic;
    private String userURL;

    public UserResponseDto(UserEntity userEntity) {
        this.userCd = userEntity.getUserCd();
        this.userNm = userEntity.getUserNm();
        this.userPic = userEntity.getUserPic();
        this.userURL = userEntity.getUserURL();
    }

}
