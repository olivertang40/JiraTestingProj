package StepDefs;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("\\d+")
    public Integer roleId(String roleId){
        return Integer.parseInt(roleId);
    }
}
