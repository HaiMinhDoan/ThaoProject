package com.devthao.animecenter.models.response;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseData implements Serializable {
    private int status;
    private String message;
    private Object data;
}
