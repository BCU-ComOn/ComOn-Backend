package kr.ac.bc.comon.springboot.common.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER_TB")
public class UserEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_CD")
    private Long userCd;

    @Column(name = "USER_ID", unique = true, nullable = false)
    private String userId;

    @Column(name = "USER_NM", nullable = false)
    private String userNm;

    @Column(name = "USER_PIC")
    private String userPic;

    @Column(name = "USER_URL")
    private String userURL;

    @Column(name = "USER_EX")
    @Type(type = "text")
    private String userEx;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFK")
    private List<GenerationEntity> generationUsers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFK")
    private List<UserFieldEntity> fieldUsers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFK")
    private List<UserLanguageEntity> languageUsers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFk", cascade = CascadeType.REMOVE)
    private List<ProjectMemberEntity> projectList = new ArrayList<>();

    @Builder
    public UserEntity(String userId,
                      String userNm) {
        this.userId = userId;
        this.userNm = userNm;
    }

}
