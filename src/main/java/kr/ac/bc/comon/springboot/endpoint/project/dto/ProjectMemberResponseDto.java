package kr.ac.bc.comon.springboot.endpoint.project.dto;

import kr.ac.bc.comon.springboot.common.domain.ProjectEntity;
import kr.ac.bc.comon.springboot.common.domain.ProjectMemberEntity;
import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectMemberResponseDto {
    private Long projectFk;
    private UserResponseDto userFk;
    private String projectMemberEx;
    private Boolean projectMstSt = false;

    public ProjectMemberResponseDto(ProjectMemberEntity entity){
        this.projectFk = entity.getProjectFk().getProjectCd();
        this.userFk = new UserResponseDto();
        this.projectMemberEx = entity.getProjectMemberEx();
        this.projectMstSt = entity.getProjectMstSt();
    }
}
