package org.re.sample.exception;

import lombok.Getter;
import org.re.goody.common.exception.DomainExceptionCode;

@Getter
public enum SampleDomainException implements DomainExceptionCode {
    MESSAGE_NOT_FOUND("SAMPLE-001","메시지를 찾을 수 없습니다."),
    MESSAGE_UPDATE_LIMIT("SAMPLE-002","메시지 수정은 세 번 이상 할 수 없습니다."),
    MESSAGE_EMPTY("SAMPLE-003","메시지는 비어 있을 수 없습니다.");

    private final String code;
    private final String message;

    SampleDomainException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
