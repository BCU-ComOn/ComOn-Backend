package kr.ac.bc.comon.springboot.common.repository;

import kr.ac.bc.comon.springboot.common.domain.LanguageEntity;
import kr.ac.bc.comon.springboot.common.domain.ProjectEntity;
import kr.ac.bc.comon.springboot.common.domain.ProjectLanguageEntity;
import kr.ac.bc.comon.springboot.common.pk.ProjectLanguagePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectLanguageRepository extends JpaRepository<ProjectLanguageEntity, ProjectLanguagePK> {
    ProjectLanguageEntity findByProjectFkAndLanguageFkNm(ProjectEntity projectFk, String languageFkNm);
    List<ProjectEntity> findAllByProjectFk(ProjectEntity projectFk);
}
