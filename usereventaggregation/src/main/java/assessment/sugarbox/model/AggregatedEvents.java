package assessment.sugarbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor @NoArgsConstructor
@Data
public class AggregatedEvents implements Serializable {
    private Integer userId;
    private String date;
    private Map<EventType, Integer> events;
}
