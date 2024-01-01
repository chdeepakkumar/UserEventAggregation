package assessment.sugarbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Event implements Serializable {
    private Integer userId;
    private EventType eventType;
    private long timestamp;
}
