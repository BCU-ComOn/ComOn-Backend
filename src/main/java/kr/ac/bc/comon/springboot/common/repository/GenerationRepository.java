package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.GenerationEntity;
import kr.ac.bc.comon.springboot.common.pk.GenerationPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository extends JpaRepository<GenerationEntity, GenerationPK> {
}
