package kr.ac.bc.comon.springboot.endpoint.user;


import kr.ac.bc.comon.springboot.common.domain.GenerationEntity;
import kr.ac.bc.comon.springboot.common.domain.UserEntity;
import kr.ac.bc.comon.springboot.common.domain.UserFieldEntity;
import kr.ac.bc.comon.springboot.common.domain.UserLanguageEntity;
import kr.ac.bc.comon.springboot.common.repository.GenerationRepository;
import kr.ac.bc.comon.springboot.common.repository.UserFieldRepository;
import kr.ac.bc.comon.springboot.common.repository.UserLanguageRepository;
import kr.ac.bc.comon.springboot.common.repository.UserRepository;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserProfileResponseDto;
import kr.ac.bc.comon.springboot.endpoint.user.dto.UserSaveRequestDto;
import kr.ac.bc.comon.springboot.util.EncryptUtil;
import org.junit.After;
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
    private  UserFieldRepository userFieldRepository;
    @Autowired
    private UserLanguageRepository userLanguageRepository;
    @Autowired
    private GenerationRepository generationRepository;
    @Autowired
    private EncryptUtil encryptUtil;

    @After
    public void tearDown() throws Exception{
        userLanguageRepository.deleteAll();
        userFieldRepository.deleteAll();
        generationRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void User_회원등록() throws Exception{
        //given
        String userId = "0909099";
        String userNm = "testUser";

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .userId(userId)
                .userNm(userNm)
                .userField("web")
                .userLanguage("java")
                .userGenerationNum(1)
                .build();

        String url = "http://localhost:" + port + "/user/join";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(1L);

        List<UserEntity> all = userRepository.findAll();
        assertThat(all.get(0).getUserNm()).isEqualTo(userNm);
        assertThat(all.get(0).getUserId()).isEqualTo(userId);
    }

    @Test
    public  void User_프로필() throws Exception{

        String userId = "0909099";
        String userNm = "testUser";

        //User_회원등록();

        UserEntity saveUser = userRepository.save(UserEntity.builder()
                .userId(userId)
                .userNm(userNm)
                .build());

        generationRepository.save(GenerationEntity.builder() //1기
                .userFK(saveUser)
                .generationNum(1)
                .generationPosition(1)
                .build());

        userFieldRepository.save(UserFieldEntity.builder()
                .userFK(saveUser)
                .fieldNmFK("wab")
                .build());

        userFieldRepository.save(UserFieldEntity.builder()
                .userFK(saveUser)
                .fieldNmFK("android")
                .build());


        userLanguageRepository.save(UserLanguageEntity.builder()
                .userFK(saveUser)
                .languageNmFK("java")
                .build());

        generationRepository.save(GenerationEntity.builder() //2기
                .userFK(saveUser)
                .generationNum(2)
                .generationPosition(0)
                .build());


        String url = "http://localhost:" + port + "/user/profile/" + userId;

        ResponseEntity<UserProfileResponseDto> responseEntity = restTemplate.getForEntity(url, UserProfileResponseDto.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getUserPosition()).isEqualTo(0);
        assertThat(responseEntity.getBody().getUserFields().size()).isEqualTo(2);
    }

}
