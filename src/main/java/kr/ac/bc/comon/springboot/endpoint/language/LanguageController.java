package kr.ac.bc.comon.springboot.endpoint.language;

import kr.ac.bc.comon.springboot.endpoint.field.dto.FieldResponseDto;
import kr.ac.bc.comon.springboot.endpoint.field.service.FieldService;
import kr.ac.bc.comon.springboot.endpoint.language.dto.LanguageResponseDto;
import kr.ac.bc.comon.springboot.endpoint.language.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequestMapping("/language")
@RequiredArgsConstructor
@RestController
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/{id}")
    public LanguageResponseDto findById(@PathVariable Long id) {
        return languageService.findById(id);
    }

    @GetMapping("/list")
    public List<LanguageResponseDto> findAll() {
        return languageService.findAll();
    }
}
