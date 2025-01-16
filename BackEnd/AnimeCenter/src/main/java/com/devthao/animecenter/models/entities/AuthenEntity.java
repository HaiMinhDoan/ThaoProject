package com.devthao.animecenter.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenEntity {
    Long userId;
    boolean isActive;
    String deviceInfo;
    Date issuedAt;
    Date expiresAt;
}
