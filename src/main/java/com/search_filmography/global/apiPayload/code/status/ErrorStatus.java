package com.search_filmography.global.apiPayload.code.status;

import com.search_filmography.global.apiPayload.code.BaseErrorCode;
import com.search_filmography.global.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    SEARCH_NOT_FOUND("SEARCH4041", "해당하는 결과물이 없습니다.");

    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return new ErrorReasonDTO(code, message);
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return new ErrorReasonDTO(code, message);
    }
}
