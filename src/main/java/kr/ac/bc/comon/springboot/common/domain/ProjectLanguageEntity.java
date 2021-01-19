package kr.ac.bc.comon.springboot.common.domain;

import kr.ac.bc.comon.springboot.common.pk.ProjectLanguagePK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PROJECT_LANGUAGE_TB")
@IdClass(ProjectLanguagePK.class)
public class ProjectLanguageEntity extends BaseTime{
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_FK", nullable = false)
    private ProjectEntity projectFk;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LANGUAGE_FK_NM", nullable = false)
    private LanguageEntity languageFkNm;

    @Builder
    public ProjectLanguageEntity(ProjectEntity projectFk, LanguageEntity languageFkNm){
        this.projectFk = projectFk;
        this.languageFkNm = languageFkNm;
    }
}
