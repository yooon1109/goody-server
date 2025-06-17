package org.re.sample.repository;

import org.re.sample.domain.Sample;
import org.re.sample.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepository extends JpaRepository<SampleEntity, Long> {
}
