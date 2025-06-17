package org.re.goody.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.re.goody.common.exception.DomainException;
import org.re.goody.common.exception.DomainExceptionCode;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {
    private final ErrorData error;

    public record ErrorData(
            String code,
            String message
    ) {

        public static ErrorData of(DomainException de) {
            return of(de.getExceptionCode());
        }

        public static ErrorData of(DomainExceptionCode dc) {
            return new ErrorData(dc.getCode(), dc.getMessage());
        }
    }
}
