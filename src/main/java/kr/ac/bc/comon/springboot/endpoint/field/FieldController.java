package kr.ac.bc.comon.springboot.endpoint.field;

import kr.ac.bc.comon.springboot.endpoint.field.dto.FieldResponseDto;
import kr.ac.bc.comon.springboot.endpoint.field.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequestMapping("/field")
@RequiredArgsConstructor
@RestController
public class FieldController {
    private final FieldService fieldService;

    @GetMapping("/{id}")
    public FieldResponseDto findById(@PathVariable Long id) {
        return fieldService.findById(id);
    }

    @GetMapping("/list")
    public List<FieldResponseDto> findAll() {
        return fieldService.findAll();
    }
}
