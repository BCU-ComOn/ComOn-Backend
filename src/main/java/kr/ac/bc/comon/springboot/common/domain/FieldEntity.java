package kr.ac.bc.comon.springboot.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "FIELD_TB")
public class FieldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIELD_CD")
    private Integer fieldCd;

    @Column(name = "FIELD_NM", nullable = false)
    private String fieldNm;

    @Builder
    public FieldEntity(String fieldNm) {
        this.fieldNm = fieldNm;
    }
}
