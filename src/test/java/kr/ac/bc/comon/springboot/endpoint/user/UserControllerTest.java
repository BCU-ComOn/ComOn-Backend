package kr.ac.bc.comon.springboot.endpoint.user;


import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.repository.UserRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.util.EncryptUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptUtil encryptUtil;


    @Test
    public void User_회원등록() throws Exception {
        //given
        String userId = "0909099";
        String userNm = "testUser";

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .userId(userId)
                .userNm(userNm)
                .userField(null)
                .userLanguage(null)
                .build();

        String shaUserId = encryptUtil.encryptSHA256(userId);

        String url = "http://localhost:" + port + "/user/join";

        //when
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, requestDto, Integer.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(1L);

        List<UserEntity> all = userRepository.findAll();
        assertThat(all.get(0).getUserNm()).isEqualTo(userNm);
        assertThat(all.get(0).getUserId()).isEqualTo(shaUserId);
    }
}
