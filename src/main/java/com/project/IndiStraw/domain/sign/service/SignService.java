package com.project.IndiStraw.domain.sign.service;

import com.project.IndiStraw.domain.sign.dto.request.SignInDto;
import com.project.IndiStraw.domain.sign.dto.request.SignUpDto;
import com.project.IndiStraw.domain.sign.dto.response.SignInResponseDto;

public interface SignService {

    Long register(SignUpDto signUpDto);
    SignInResponseDto login(SignInDto signInDto);
}
