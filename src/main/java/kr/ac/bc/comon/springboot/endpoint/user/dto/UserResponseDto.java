package kr.ac.bc.comon.springboot.endpoint.user.dto;

import kr.ac.bc.comon.springboot.common.domain.FieldEntity;
import kr.ac.bc.comon.springboot.common.domain.LanguageEntity;
import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.endpoint.field.dto.FieldResponseDto;
import kr.ac.bc.comon.springboot.endpoint.language.dto.LanguageResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
public class UserResponseDto {
    private Long userCd;
    private String userNm;
    private String userPic;
    private String userURL;
    private Integer userPosition;
    private List<UserFieldDto> userFields;
    private List<UserLanguageDto> userLanguages;

    public UserResponseDto(UserEntity userEntity){
        this.userCd = userEntity.getUserCd();
        this.userNm = userEntity.getUserNm();
        this.userPic = userEntity.getUserPic();
        this.userURL = userEntity.getUserURL();
        this.userFields = userEntity.getFieldUsers()
                .stream()
                .map(UserFieldDto::new)
                .collect(Collectors.toList());

        this.userLanguages = userEntity.getLanguageUsers()
                .stream()
                .map(UserLanguageDto::new)
                .collect(Collectors.toList());
    }


}
