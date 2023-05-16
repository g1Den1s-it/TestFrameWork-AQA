package org.framework.api.elements.token;

import lombok.Data;

@Data
public class Token {
    private String refresh;
    public String access;
}
