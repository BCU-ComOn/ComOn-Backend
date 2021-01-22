package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserCd(Long userCd);
    UserEntity findByUserId(String userId);

    List<UserEntity> findAllByUserNmLike(String userNm);
}
