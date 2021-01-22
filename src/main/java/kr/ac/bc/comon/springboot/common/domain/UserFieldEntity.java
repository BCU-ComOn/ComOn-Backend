package kr.ac.bc.comon.springboot.common.domain;

import kr.ac.bc.comon.springboot.common.pk.UserFieldPK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER_FIELD_TB")
@IdClass(UserFieldPK.class)
public class UserFieldEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FK")
    private UserEntity userFK;

    @Id
    @Column(name = "FIELD_FK_NM")
    private String fieldNmFK;

    @Builder
    public UserFieldEntity(UserEntity userFK,
                           String fieldNmFK) {
        this.userFK = userFK;
        this.fieldNmFK = fieldNmFK;
    }

}
