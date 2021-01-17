package kr.ac.bc.comon.springboot.endpoint.user;

import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.endpoint.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Transactional
@RequestMapping("user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public Long join(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }
}
