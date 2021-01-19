package kr.ac.bc.comon.springboot.common.domain;

import kr.ac.bc.comon.springboot.common.pk.ProjectMemberPK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PROJECT_LANGUAGE_TB")
@IdClass(ProjectMemberPK.class)
public class ProjectMemberEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_FK", nullable = false)
    private ProjectEntity projectFk;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FK", nullable = false)
    private UserEntity userFk;

    @Column(name = "PROJECT_MEMBER_EX")
    private String projectMemberEx;

    @Column(name = "PROJECT_MST_ST", nullable = false)
    private Boolean projectMstSt;

    @Builder
    public ProjectMemberEntity(ProjectEntity projectFk,
                               UserEntity userFk,
                               String projectMemberEx,
                               Boolean projectMstSt){
        this.projectFk = projectFk;
        this.userFk = userFk;
        this.projectMemberEx = projectMemberEx;
        this.projectMstSt = projectMstSt;
    }
}
