package kr.ac.bc.comon.springboot.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "HISTORY_TB")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_CD")
    private Long historyCd;

    @Column(name = "HISTORY_EX")
    private String historyEx;

    @Column(name = "HISTORY_DT")
    private Date historyDt;

    @Builder
    public HistoryEntity(String historyEx,
                      Date historyDt) {
        this.historyEx = historyEx;
        this.historyDt = historyDt;
    }
}
