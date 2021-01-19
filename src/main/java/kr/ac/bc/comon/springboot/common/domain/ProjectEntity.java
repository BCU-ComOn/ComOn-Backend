package kr.ac.bc.comon.springboot.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PROJECT_TB")
public class ProjectEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_CD")
    private Long projectCd;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_FK_NM")
    private FieldEntity fieldFkNm;

    @Column(name = "PROJECT_NM", nullable = false)
    private String projectNm;

    @Column(name = "PROJECT_PIC")
    private String projectPic;

    @Column(name = "PROJECT_EX")
    private String projectEx;

    @Column(name = "PROJECT_PROGRESS", nullable = false)
    private Integer projectProgress;

    @Column(name = "PROJECT_GENERATION_NUM", nullable = false)
    private Integer projectGenerationNum;

    @Column(name = "PROJECT_URL")
    private String projectUrl;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectFk", cascade = CascadeType.REMOVE)
    private List<ProjectLanguageEntity> languageList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectFk", cascade = CascadeType.REMOVE)
    private List<ProjectMemberEntity> userList = new ArrayList<>();

    @Builder
    public ProjectEntity(FieldEntity fieldFkNm,
                         String projectNm,
                         String projectPic,
                         String projectEx,
                         Integer projectProgress,
                         Integer projectGenerationNum,
                         String projectUrl){
        this.fieldFkNm = fieldFkNm;
        this.projectNm = projectNm;
        this.projectPic = projectPic;
        this.projectEx = projectEx;
        this.projectProgress = projectProgress;
        this.projectGenerationNum = projectGenerationNum;
        this.projectUrl = projectUrl;
    }
}