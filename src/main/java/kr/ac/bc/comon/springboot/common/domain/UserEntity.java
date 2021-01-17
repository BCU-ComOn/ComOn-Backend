package kr.ac.bc.comon.springboot.common.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER_TB")
public class UserEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_CD")
    private Long userCd;

    @Column(name = "USER_ID", unique=true, nullable = false)
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


    @Builder
    public UserEntity(String userId,
                      String userNm) {
        this.userId = userId;
        this.userNm = userNm;
    }
}
