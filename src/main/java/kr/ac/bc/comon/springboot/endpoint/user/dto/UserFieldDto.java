package kr.ac.bc.comon.springboot.endpoint.user.dto;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.domain.UserFieldEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserFieldDto {
    private String fieldNm;

    @Builder
    public UserFieldDto(UserFieldEntity userFieldEntity){
        this.fieldNm = userFieldEntity.getFieldNmFK();
    }

    public UserFieldEntity toEntity(UserEntity user, String fieldNm){
        return UserFieldEntity.builder()
                .userFK(user)
                .fieldNmFK(fieldNm)
                .build();
    }
}
