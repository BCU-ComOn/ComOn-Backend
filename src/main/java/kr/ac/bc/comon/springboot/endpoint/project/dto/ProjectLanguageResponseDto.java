package kr.ac.bc.comon.springboot.endpoint.project.dto;

import kr.ac.bc.comon.springboot.common.domain.LanguageEntity;
import kr.ac.bc.comon.springboot.common.domain.ProjectLanguageEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectLanguageResponseDto {
    private Long projectFk;
    private String languageFkNm;

    public ProjectLanguageResponseDto(ProjectLanguageEntity entity){
        this.projectFk = entity.getProjectFk().getProjectCd();
        this.languageFkNm = entity.getLanguageFkNm().getLanguageNm();
    }
}
