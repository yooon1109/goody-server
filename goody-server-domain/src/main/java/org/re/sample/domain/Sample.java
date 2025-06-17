package org.re.sample.domain;
import lombok.Getter;
import org.re.goody.common.exception.DomainException;
import org.re.goody.common.util.Constants;
import org.re.sample.exception.SampleDomainException;


@Getter
public class Sample {

    private final Long id;

    private String message;

    private int count;

    private Sample(Long id, String message, int count) {
        this.id = id;
        this.message = message;
        this.count = count;
    }

    public static Sample of(Long id, String message, int count) {
        return new Sample(id, message, count);
    }

    public static Sample of(String message) {
        return new Sample(null, message, Constants.ZERO);
    }

    public void updateMessage(String newMessage) {
        if (newMessage == null || newMessage.isBlank()) {
            throw new DomainException(SampleDomainException.MESSAGE_EMPTY);
        }

        if(this.count >= 3){
            throw new DomainException(SampleDomainException.MESSAGE_UPDATE_LIMIT);
        }
        this.message = newMessage;
        this.count++;
    }
}
