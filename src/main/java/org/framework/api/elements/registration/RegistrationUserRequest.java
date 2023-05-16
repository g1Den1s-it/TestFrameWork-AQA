package org.framework.api.elements.registration;

import lombok.Data;

@Data
public class RegistrationUserRequest {
    private String  username;
    public String  password;
    public String email;
}
