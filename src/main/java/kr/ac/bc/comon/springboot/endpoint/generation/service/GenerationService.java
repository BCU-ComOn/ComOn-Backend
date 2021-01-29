package kr.ac.bc.comon.springboot.endpoint.generation.service;


import kr.ac.bc.comon.springboot.common.domain.GenerationEntity;
import kr.ac.bc.comon.springboot.common.repository.GenerationRepository;
import kr.ac.bc.comon.springboot.endpoint.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GenerationService {
    private final UserService userService;

    private final GenerationRepository generationRepository;

    @Transactional
    public Boolean save(Long userCd, Integer generationNum){
        GenerationEntity generationEntity = GenerationEntity.builder()
                .userFK(userService.findEntity(userCd))
                .generationNum(generationNum)
                .generationPosition(1)
                .build();

        return Optional.ofNullable(generationRepository.save(generationEntity)).isPresent();
    }

    public  Integer currentGeneration() throws ParseException {
        SimpleDateFormat dateFormat= new SimpleDateFormat( "yyyy-MM-dd" );
        int result = 0;
        Date startDt = dateFormat.parse("2020-09-01");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date()); // today

        while (cal.getTime().compareTo(startDt) > 0){ // today가 str날짜보다 작을때
            result ++;
            cal.add(Calendar.MONTH, -6);
        }
        return result;
    }
}

