package org.re.sample.service;

import lombok.RequiredArgsConstructor;
import org.re.goody.common.annotation.DomainService;
import org.re.goody.common.exception.DomainException;
import org.re.sample.SampleRepository;
import org.re.sample.domain.Sample;
import org.re.sample.exception.SampleDomainException;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class SampleDomainService {
    private final SampleRepository sampleRepository;

    public Optional<Sample> findSampleById(Long id) {
        return sampleRepository.findById(id);
    }

    public Sample saveSample(String message) {
        Sample sample = Sample.of(message);
        return sampleRepository.save(sample);
    }

    public Sample updateSampleMessage(Long id, String newMessage) {
        Sample sample = sampleRepository.findById(id)
                .orElseThrow(() -> new DomainException(SampleDomainException.MESSAGE_NOT_FOUND));

        // 도메인 엔티티의 메서드를 호출해 상태 변경 (도메인 규칙 반영)
        sample.updateMessage(newMessage);

        return sampleRepository.save(sample);
    }

}
