package com.project.IndiStraw.domain.sign.service;

import com.project.IndiStraw.domain.sign.dto.request.SignInDto;
import com.project.IndiStraw.domain.sign.dto.request.SignUpDto;
import com.project.IndiStraw.domain.sign.dto.response.SignInResponseDto;
import com.project.IndiStraw.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SignServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignService signService;

    @Test
    @DisplayName("회원가입 테스트")
    void register() {

        // given
        SignUpDto signUpDto = SignUpDto.builder()
                .username("김성길")
                .email("sunggil0125@naver.com")
                .password("1234")
                .build();

        // when
        Long register = signService.register(signUpDto);

        // then
        assertThat(register).isEqualTo(userRepository.findByEmail(signUpDto.getEmail()).orElseThrow().getUser_id());
    }

    @Test
    @DisplayName("로그인 테스트")
    void login() {

        // given
        SignInDto signInDto = SignInDto.builder()
                .email("sunggil0125@naver.com")
                .password("1234")
                .build();

        // when
        SignInResponseDto login = signService.login(signInDto);

        // then
        assertThat(login).isNotNull();
    }
}