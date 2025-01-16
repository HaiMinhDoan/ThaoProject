package com.devthao.animecenter.models.request;

import com.devthao.animecenter.models.entities.AuthenEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CommentRequest {
    AuthenEntity authenEntity;
    Long movieId;
    String content;
}
