package com.project.IndiStraw.domain.sign.service.Impl;

import com.project.IndiStraw.domain.sign.dto.request.RefreshTokenDto;
import com.project.IndiStraw.domain.sign.service.RefreshTokenService;
import com.project.IndiStraw.domain.user.User;
import com.project.IndiStraw.domain.user.repository.UserRepository;
import com.project.IndiStraw.global.exception.exceptions.InvalidTokenException;
import com.project.IndiStraw.global.exception.exceptions.RefreshTokenExpirationException;
import com.project.IndiStraw.global.exception.exceptions.UserNotFoundException;
import com.project.IndiStraw.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.project.IndiStraw.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public Map<String, String> refreshToken(String refreshToken, RefreshTokenDto refreshTokenDto) {

        User user = userRepository.findByEmail(refreshTokenDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Map<String, String> token = new HashMap<>();
        if(!jwtTokenProvider.isExpired(refreshToken) && user.getRefreshToken().equals(refreshToken)) {

            if (user.getRefreshToken() == null) {
                throw new InvalidTokenException(INVALID_TOKEN);
            }

            String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
            token.put("accessToken", accessToken);

            return token;
        }

        throw new RefreshTokenExpirationException(REFRESH_TOKEN_EXPIRATION);
    }
}
