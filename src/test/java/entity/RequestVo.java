package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class RequestVo {
    private String id;
    private String title;
    private String type;
    private Boolean additionalProperties;
    private String name;
}
