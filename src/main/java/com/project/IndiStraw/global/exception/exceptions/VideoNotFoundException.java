package com.project.IndiStraw.global.exception.exceptions;

import com.project.IndiStraw.global.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VideoNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

}
