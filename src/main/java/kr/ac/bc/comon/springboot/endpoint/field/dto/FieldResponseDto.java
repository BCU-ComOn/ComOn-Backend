package kr.ac.bc.comon.springboot.endpoint.field.dto;

import kr.ac.bc.comon.springboot.common.domain.FieldEntity;
import lombok.Getter;

@Getter
public class FieldResponseDto {
    private long fieldCd;
    private String fieldNm;

    public FieldResponseDto(FieldEntity fieldEntity) {
        this.fieldCd = fieldEntity.getFieldCd();
        this.fieldNm = fieldEntity.getFieldNm();
    }
}
