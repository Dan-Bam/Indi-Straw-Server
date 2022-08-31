package com.project.IndiStraw.domain.sign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
@Builder
public class SignInResponseDto {

    private Map<String, String> token;
}
