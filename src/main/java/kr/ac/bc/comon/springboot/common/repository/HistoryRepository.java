package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
}
