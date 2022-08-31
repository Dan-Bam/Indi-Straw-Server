package com.project.IndiStraw.domain.sign.service;

import com.project.IndiStraw.domain.sign.dto.request.SignInDto;
import com.project.IndiStraw.global.util.CurrentUserUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RefreshTokenServiceImplTest {

    @Autowired
    private CurrentUserUtil currentUserUtil;

    @Autowired
    private SignService signService;

    @Test
    @DisplayName("refreshToken 테스트")
    void refreshToken() {

        // given
        SignInDto signInDto = SignInDto.builder()
                .email("s21023@gsm.hs.kr")
                .password("1234")
                .build();
        signService.login(signInDto);

        // when


        // then
    }
}