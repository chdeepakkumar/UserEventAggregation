package assessment.sugarbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class Pair {
    private Integer userId;
    private String date;
}
