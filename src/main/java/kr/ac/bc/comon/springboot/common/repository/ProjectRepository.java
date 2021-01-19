package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    ProjectEntity findByProjectCd(Long projectCd);
    List<ProjectEntity> findByProjectProgress(Integer projectProgress);
    List<ProjectEntity> findByProjectGenerationNum(Integer projectGenerationNum);
}
