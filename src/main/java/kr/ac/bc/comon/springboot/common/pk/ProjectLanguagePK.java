package kr.ac.bc.comon.springboot.common.pk;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class ProjectLanguagePK implements Serializable {
    private Long projectFk;
    private String languageFkNm;
}
