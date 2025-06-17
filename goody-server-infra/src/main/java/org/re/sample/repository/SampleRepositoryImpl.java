package org.re.sample.repository;

import lombok.RequiredArgsConstructor;
import org.re.sample.SampleRepository;
import org.re.sample.domain.Sample;
import org.re.sample.entity.SampleEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepository {
    private final SampleJpaRepository sampleJpaRepository;

    @Override
    public Optional<Sample> findById(Long id) {
        return sampleJpaRepository.findById(id)
                .map(SampleEntity::toDomain);
    }

    @Override
    public Sample save(Sample sample) {
        SampleEntity sampleEntity = SampleEntity.toEntity(sample);
        SampleEntity saved = sampleJpaRepository.save(sampleEntity);
        return saved.toDomain();
    }
}
