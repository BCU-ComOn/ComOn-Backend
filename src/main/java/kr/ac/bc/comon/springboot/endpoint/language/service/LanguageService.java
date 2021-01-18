package kr.ac.bc.comon.springboot.endpoint.language.service;

import kr.ac.bc.comon.springboot.common.domain.FieldEntity;
import kr.ac.bc.comon.springboot.common.domain.LanguageEntity;
import kr.ac.bc.comon.springboot.common.repository.FieldRepository;
import kr.ac.bc.comon.springboot.common.repository.LanguageRepository;
import kr.ac.bc.comon.springboot.endpoint.field.dto.FieldResponseDto;
import kr.ac.bc.comon.springboot.endpoint.language.dto.LanguageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    @Transactional(readOnly = true)
    public LanguageResponseDto findById(Integer id) {
        LanguageEntity languageEntity = languageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 분야가 없습니다. id=" + id));

        return new LanguageResponseDto(languageEntity);
    }

    @Transactional(readOnly = true)
    public List<LanguageResponseDto> findAll() {
        return languageRepository.findAll().stream()
                .map(LanguageResponseDto::new)
                .collect(Collectors.toList());
    }
}
