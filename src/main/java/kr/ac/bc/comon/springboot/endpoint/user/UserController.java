package kr.ac.bc.comon.springboot.endpoint.user;

import kr.ac.bc.comon.springboot.endpoint.generation.service.GenerationService;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserProfileResponseDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserResponseDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.endpoint.user.service.UserFieldService;
import kr.ac.bc.comon.springboot.endpoint.user.service.UserLanguageService;
import kr.ac.bc.comon.springboot.endpoint.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "https://bcu-comon.github.io/ComOn")
@Transactional
@RequestMapping("user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserFieldService userFieldService;
    private  final UserLanguageService userLanguageService;
    private final GenerationService generationService;

    @PostMapping("/join")
    public Long join(@RequestBody UserSaveRequestDto requestDto){
        Long userCd =  userService.save(requestDto);
        generationService.save(userCd, requestDto.getUserGenerationNum());
        if(requestDto.getUserLanguage() != null)userLanguageService.save(userCd, requestDto.getUserLanguage());
        if(requestDto.getUserField() != null)userFieldService.save(userCd, requestDto.getUserField());
        return  userCd;
    }

    @GetMapping("profile/{userId}")
    public UserProfileResponseDto userProfile(@PathVariable  String userId)
    {
        return userService.getUserProfile(userId);
    }

    @GetMapping("search/{userNm}")
    public List<UserResponseDto> userSearch(@PathVariable String userNm){
        return userService.findByUserNm(userNm);
    }
}
