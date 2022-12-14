package com.project.IndiStraw.domain.sign.dto.request;

import com.project.IndiStraw.domain.sign.enumType.Role;
import com.project.IndiStraw.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SignUpDto {

    @NotBlank
    @Size(min = 2, max = 5)
    private String username;

    @NotBlank
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?", message = "이메일 형식이 아닙니다")
    private String email;

    @NotBlank
//    @Pattern(regexp = "[\\w]{2,}", message = "영문, 숫자, 특문 중 2개 조합이여야 합니다") // 비밀번호 message적기
    @Size(min = 10, max = 20)
    private String password;

    public User toEntity(String password) {
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(Collections.singletonList(Role.ROLE_USER))
                .build();
    }
}
