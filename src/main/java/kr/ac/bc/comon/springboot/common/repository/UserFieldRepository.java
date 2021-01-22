package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.domain.UserFieldEntity;
import kr.ac.bc.comon.springboot.common.pk.UserFieldPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFieldRepository extends JpaRepository<UserFieldEntity, UserFieldPK> {
    List<UserFieldEntity> findByUserFK(UserEntity userEntity);
}
