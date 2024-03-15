package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String key;
    private String name;
    private String password;
    private String emailAddress;
    private String displayName;
    //private String[] applicationKeys;
    private List<String> applicationKeys;

    public void addKey(String key){
        applicationKeys.add(key);
    }
}
