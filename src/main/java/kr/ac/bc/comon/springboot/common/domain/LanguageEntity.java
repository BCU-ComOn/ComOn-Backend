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
@Table(name = "LANGUAGE_TB")
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LANGUAGE_CD")
    private Long languageCd;

    @Column(name = "LANGUAGE_NM", nullable = false)
    private String languageNm;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "languageFkNm", cascade = CascadeType.REMOVE)
    private List<ProjectLanguageEntity> projectList = new ArrayList<>();

    @Builder
    public LanguageEntity(String languageNm) {
        this.languageNm = languageNm;
    }
}
