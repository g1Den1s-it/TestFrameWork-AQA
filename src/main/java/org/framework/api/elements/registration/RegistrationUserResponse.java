package org.framework.api.elements.registration;

import lombok.Data;

@Data
public class RegistrationUserResponse {
    private Integer codeStatus;
    public User user;
}
