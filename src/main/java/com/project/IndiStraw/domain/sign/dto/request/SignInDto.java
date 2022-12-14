package com.project.IndiStraw.domain.sign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {

    @Email
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?", message = "이메일 형식이 아닙니다")
    private String email;

    @Size(min = 10, max = 20)
    private String password;
}
