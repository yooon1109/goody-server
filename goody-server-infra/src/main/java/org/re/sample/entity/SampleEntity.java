package org.re.sample.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.re.sample.domain.Sample;

@Entity
@Table(name = "sample")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private int count;

    public SampleEntity(Long id, String message, int count) {
        this.id = id;
        this.message = message;
        this.count = count;
    }

    public static SampleEntity toEntity(Sample sample) {
        return new SampleEntity(sample.getId(),sample.getMessage(),sample.getCount());
    }

    public Sample toDomain() {
        return Sample.of(id,message,count);
    }
}
