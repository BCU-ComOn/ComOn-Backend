package kr.ac.bc.comon.springboot.endpoint.project.dto;

import kr.ac.bc.comon.springboot.common.domain.FieldEntity;
import kr.ac.bc.comon.springboot.common.domain.ProjectEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectResponseDto {
    private Long projectCd;
    private String fieldFkNm;
    private String projectNm;
    private String projectPic;
    private String projectEx;
    private Integer projectProgress = 0;
    private Integer projectGenerationNum;
    private String projectUrl;

    public ProjectResponseDto(ProjectEntity entity){
        this.projectCd = entity.getProjectCd();
        this.fieldFkNm = entity.getFieldFkNm().getFieldNm();
        this.projectNm = entity.getProjectNm();
        this.projectPic = entity.getProjectPic();
        this.projectEx = entity.getProjectEx();
        this.projectGenerationNum = entity.getProjectGenerationNum();
        this.projectUrl = entity.getProjectUrl();
    }
}
