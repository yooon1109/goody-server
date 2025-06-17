package org.re.goody.common.annotation;


import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Service
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainService {
    // application 계층의 service 와 구분하기 위해 @domainService 생성
    // 기능적으로는 기존의 @Service 와 동일
}