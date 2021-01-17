package kr.ac.bc.comon.springboot.common.pk;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class UserFieldPK implements Serializable {
    private Long userFK;
    private Long fieldFK;
}
