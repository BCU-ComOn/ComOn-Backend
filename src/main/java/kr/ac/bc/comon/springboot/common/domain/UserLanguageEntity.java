package kr.ac.bc.comon.springboot.common.domain;

import kr.ac.bc.comon.springboot.common.pk.UserLanguagePK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER_LANGUAGE_TB")
@IdClass(UserLanguagePK.class)
public class UserLanguageEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FK")
    private UserEntity userFK;

    @Id
    @Column(name = "LANGUAGE_FK_NM")
    private String languageNmFK;

    @Builder
    public UserLanguageEntity(UserEntity userFK,
                           String languageNmFK) {
        this.userFK = userFK;
        this.languageNmFK = languageNmFK;
    }
}
