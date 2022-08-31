package com.project.IndiStraw.domain.sign.controller;

import com.project.IndiStraw.domain.sign.dto.request.RefreshTokenDto;
import com.project.IndiStraw.domain.sign.service.RefreshTokenService;
import com.project.IndiStraw.global.response.ResponseService;
import com.project.IndiStraw.global.response.result.SingleResult;
import com.project.IndiStraw.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/")
public class RefreshTokenController {

    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final RefreshTokenService refreshTokenService;

    @PutMapping("refreshToken")
    public SingleResult<Map<String, String>> refreshToken(HttpServletRequest request, @Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        Map<String, String> data = refreshTokenService.refreshToken(jwtTokenProvider.getRefreshToken(request), refreshTokenDto);
        return responseService.getSingleResult(data);
    }
}
