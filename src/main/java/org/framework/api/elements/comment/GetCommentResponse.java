package org.framework.api.elements.comment;

import lombok.Data;

@Data
public class GetCommentResponse {
    private Integer codeStatus;
    private Comment comment;
}
