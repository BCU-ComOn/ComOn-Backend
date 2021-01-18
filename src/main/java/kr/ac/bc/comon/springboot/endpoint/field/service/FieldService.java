package kr.ac.bc.comon.springboot.endpoint.field.service;

import kr.ac.bc.comon.springboot.common.domain.FieldEntity;
import kr.ac.bc.comon.springboot.common.repository.FieldRepository;
import kr.ac.bc.comon.springboot.endpoint.field.dto.FieldResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FieldService {
    private final FieldRepository fieldRepository;

    @Transactional(readOnly = true)
    public FieldResponseDto findById(Long id) {
        FieldEntity fieldEntity = fieldRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 분야가 없습니다. id=" + id));

        return new FieldResponseDto(fieldEntity);
    }

    @Transactional(readOnly = true)
    public List<FieldResponseDto> findAll() {
        return fieldRepository.findAll().stream()
                .map(FieldResponseDto::new)
                .collect(Collectors.toList());
    }
}
