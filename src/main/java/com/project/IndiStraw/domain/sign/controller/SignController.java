package com.project.IndiStraw.domain.sign.controller;

import com.project.IndiStraw.domain.sign.dto.request.SignInDto;
import com.project.IndiStraw.domain.sign.dto.request.SignUpDto;
import com.project.IndiStraw.domain.sign.dto.response.SignInResponseDto;
import com.project.IndiStraw.domain.sign.service.SignService;
import com.project.IndiStraw.global.response.ResponseService;
import com.project.IndiStraw.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/")
public class SignController {

    private final SignService signService;
    private final ResponseService responseService;

    @PostMapping("signup")
    public CommonResultResponse signup(@Valid @RequestBody SignUpDto signUpDto) {
        signService.register(signUpDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("signin")
    public CommonResultResponse signin(@Valid @RequestBody SignInDto signInDto) {
        SignInResponseDto result = signService.login(signInDto);
        return responseService.getSingleResult(result);
    }
}
