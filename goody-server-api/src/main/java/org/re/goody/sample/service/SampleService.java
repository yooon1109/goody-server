package org.re.goody.sample.service;

import lombok.RequiredArgsConstructor;
import org.re.sample.domain.Sample;
import org.springframework.transaction.annotation.Transactional;
import org.re.sample.service.SampleDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SampleService {
    private final SampleDomainService sampleDomainService;

    public Sample saveSample(String message) {
        return sampleDomainService.saveSample(message);
    }

    public Sample updateMessage(Long id, String newMessage) {
        return sampleDomainService.updateSampleMessage(id, newMessage);
    }

    public Optional<Sample> findById(Long id) {
        return sampleDomainService.findSampleById(id);
    }
}
