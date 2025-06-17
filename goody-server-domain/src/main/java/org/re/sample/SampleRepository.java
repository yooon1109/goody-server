package org.re.sample;

import org.re.sample.domain.Sample;

import java.util.Optional;

public interface SampleRepository {
    Optional<Sample> findById(Long id);
    Sample save(Sample sample);
}
