package kr.ac.bc.comon.springboot.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "LANGUAGE_TB")
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LANGUAGE_CD")
    private Integer languageCd;

    @Column(name = "LANGUAGE_NM", nullable = false)
    private String languageNm;

    @Builder
    public LanguageEntity(String languageNm) {
        this.languageNm = languageNm;
    }
}
