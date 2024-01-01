package assessment.sugarbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

@Getter
public enum EventType implements Serializable {
    @JsonProperty("post")
    POST("post"),
    @JsonProperty("likeReceived")
    LIKE("like"),
    @JsonProperty("comment")
    COMMENT("comment");

    private final String value;

    EventType(String value) {
        this.value = value;
    }

    public EventType getEvent(String value) throws Exception {
        for(EventType eventType: EventType.values()) {
            if(eventType.getValue().equals(value))
                return eventType;
        }
        throw new Exception("Invalid Event Value");
    }
}
