package kr.ac.bc.comon.springboot.endpoint.user.dto;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.domain.UserFieldEntity;
import kr.ac.bc.comon.springboot.common.domain.UserLanguageEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLanguageDto {
    private String languageNm;

    @Builder
    public UserLanguageDto(UserLanguageEntity userLanguageEntity){
        this.languageNm = userLanguageEntity.getLanguageNmFK();
    }

    public UserLanguageEntity toEntity( UserEntity user, String LanguageNm){
        return UserLanguageEntity.builder()
                .languageNmFK(LanguageNm)
                .userFK(user)
                .build();
    }
}
