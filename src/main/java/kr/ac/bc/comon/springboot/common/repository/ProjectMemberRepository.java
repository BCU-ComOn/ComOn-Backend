package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.ProjectEntity;
import kr.ac.bc.comon.springboot.common.domain.ProjectMemberEntity;
import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.pk.ProjectMemberPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMemberEntity, ProjectMemberPK> {
    ProjectMemberEntity findByProjectFkAndUserFk(ProjectEntity projectFk, UserEntity userFk);
    List<ProjectMemberEntity> findAllByProjectFk(ProjectEntity projectFk);
    List<ProjectMemberEntity> findAllByUserFk(UserEntity userFk);
}
