package com.project.IndiStraw.global.response;

import com.project.IndiStraw.global.response.result.CommonResultResponse;
import com.project.IndiStraw.global.response.result.SingleResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    @Getter
    @AllArgsConstructor
    public enum CommonResponse{
        SUCCESS(true, "아싸뵹!", 200);

        private boolean success;
        private String message;
        private int status;
    }

    public CommonResultResponse getSuccessResult() {
        return getCommonResultResponse();
    }

    public <T> SingleResult<T> getSingleResult(T result) {
        return new SingleResult<T>(getCommonResultResponse(), result);
    }

    private CommonResultResponse getCommonResultResponse() {
        return new CommonResultResponse(CommonResponse.SUCCESS.isSuccess(), CommonResponse.SUCCESS.getMessage(), CommonResponse.SUCCESS.getStatus());
    }
}
