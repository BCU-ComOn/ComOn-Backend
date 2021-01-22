package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.domain.UserLanguageEntity;
import kr.ac.bc.comon.springboot.common.pk.UserLanguagePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLanguageRepository extends JpaRepository<UserLanguageEntity, UserLanguagePK> {
    List<UserLanguageEntity> findByUserFK(UserEntity userEntity);
}
