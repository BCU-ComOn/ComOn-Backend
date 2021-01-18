package kr.ac.bc.comon.springboot.endpoint.language.dto;

import kr.ac.bc.comon.springboot.common.domain.FieldEntity;
import kr.ac.bc.comon.springboot.common.domain.LanguageEntity;
import lombok.Getter;

@Getter
public class LanguageResponseDto {
    private Integer languageCd;
    private String languageNm;

    public LanguageResponseDto(LanguageEntity languageEntity) {
        this.languageCd = languageEntity.getLanguageCd();
        this.languageNm = languageEntity.getLanguageNm();
    }
}