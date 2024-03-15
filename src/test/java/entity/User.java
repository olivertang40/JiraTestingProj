package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //private String key;
    private String name;
    private String password;
    private String emailAddress;
    private String displayName;
    private String[] applicationKeys;
}
