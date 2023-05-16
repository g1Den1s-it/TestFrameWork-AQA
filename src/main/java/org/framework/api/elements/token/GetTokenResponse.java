package org.framework.api.elements.token;

import lombok.Data;

@Data
public class GetTokenResponse {
    private Integer codeStatus;
    private Token token;
}
