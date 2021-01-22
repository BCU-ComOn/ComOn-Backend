package kr.ac.bc.comon.springboot.endpoint.user.dto;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String userId;
    private String userNm;
    private String userField;
    private String userLanguage;
    private Integer userGenerationNum;

    @Builder
    public UserSaveRequestDto(String userId,
                              String userNm,
                              String userField,
                              String userLanguage,
                              Integer userGenerationNum){
        this.userId = userId;
        this.userNm = userNm;
        this.userField = userField;
        this.userLanguage = userLanguage;
        this.userGenerationNum = userGenerationNum;
    }

    public UserEntity toEntity(String userId){
        return UserEntity.builder()
                .userId(userId)
                .userNm(userNm)
                .build();
    }


}
