package com.devthao.animecenter.models.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {
    private String email;
    private String password;
    private String deviceInfo;
}
