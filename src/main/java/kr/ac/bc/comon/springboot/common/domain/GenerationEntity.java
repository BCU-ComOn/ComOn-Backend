package kr.ac.bc.comon.springboot.common.domain;

import kr.ac.bc.comon.springboot.common.pk.GenerationPK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "GENERATION_TB")
@IdClass(GenerationPK.class)
public class GenerationEntity extends BaseTime {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FK")
    private UserEntity userFK;

    @Id
    @Column(name = "GENERATION_NUM")
    private Integer generationNum;

    @Column(name = "GENERATION_POSITION")
    private Integer generationPosition;

    @Builder
    private GenerationEntity(UserEntity userFK,
                             Integer generationNum,
                             Integer generationPosition) {
        this.userFK = userFK;
        this.generationNum = generationNum;
        this.generationPosition = generationPosition;
    }
}
