package org.framework.api.elements.comment;

import lombok.Data;

@Data
public class GetCommentRequest {
    private Integer codeStatus;
    private Comment comment;
}
