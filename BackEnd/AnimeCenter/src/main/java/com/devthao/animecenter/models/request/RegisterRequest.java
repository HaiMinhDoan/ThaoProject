package com.devthao.animecenter.models.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest implements Serializable {
    String email;
    String username;
    String password;
}
